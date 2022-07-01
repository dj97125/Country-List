package com.example.countrylist.Model.Network.CountryRepository


import com.example.countrylist.Common.*
import com.example.countrylist.Model.Local.CountryDao
import com.example.countrylist.Model.Network.NetworkAPI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface NetworkRepository {
    suspend fun countryCached(): Flow<StateAction>
}

class NetworkRepositoryImpl @Inject constructor(
    private val service: NetworkAPI,
    private val dao: CountryDao
) : NetworkRepository {


    override suspend fun countryCached() = flow {
        emit(StateAction.LOADING)
        try {
            val connected = InternetCheck()
            if (connected.isConnected()) {
                emit(StateAction.MESSAGE("Loading data from server"))
                val response = service.getCountriesList()
                if (response.isSuccessful) {
                    response.body()?.let { result ->
                        dao.deleteAllCountryLocalItem()
                        dao.insertLocalCountry(result.map { it.toDatabase() })
                        emit(StateAction.SUCCESS(result.map { it.toDomain() }))
                    } ?: throw NullResponseException()
                } else {
                    throw FailedResponseException()
                }
            } else {
                emit(StateAction.MESSAGE("Loading from cache"))
                val cache = dao.getAllCachedCountries()
                if (!cache.isNullOrEmpty()) {
                    emit(StateAction.SUCCESS(cache.map { it.toDomain() }))
                } else {
                    throw FailedCache()
                }
            }
        } catch (e: Exception) {
            emit(StateAction.ERROR(e))
        }
    }
}