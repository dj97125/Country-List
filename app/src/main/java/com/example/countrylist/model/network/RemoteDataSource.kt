package com.example.countrylist.model.network

import com.example.countrylist.common.FailedResponseException
import com.example.countrylist.common.NullResponseException
import com.example.countrylist.common.StateAction
import com.example.countrylist.domain.Country
import com.example.countrylist.model.network.country_response.CountriesResponseItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface RemoteDataSource {
    suspend fun countryCached(): Flow<StateAction>
}

class ServiceDataSource @Inject constructor(
    private val service: NetworkAPI
) : RemoteDataSource {

    override suspend fun countryCached() = flow {
        emit(StateAction.MESSAGE("Loading data from server"))
        try {
            val response = service.getCountriesList()
            if (response.isSuccessful) {
                response.body()?.let { result ->
                    emit(StateAction.SUCCESS(result.map { it.toDomainModel() }))
                } ?: throw NullResponseException()
            } else {
                throw FailedResponseException()
            }
        } catch (e: Exception) {
            emit(StateAction.ERROR(e))
        }
    }

}

private fun List<CountriesResponseItem>.toDomainModel(): List<Country> = map {
    it.toDomainModel()
}

private fun CountriesResponseItem.toDomainModel(): Country =
    Country(capital, code, name, region)
