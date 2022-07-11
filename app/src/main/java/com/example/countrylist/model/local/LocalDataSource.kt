package com.example.countrylist.model.local

import com.example.countrylist.common.FailedCache
import com.example.countrylist.common.StateAction
import com.example.countrylist.domain.Country
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface LocalDataSource {
    suspend fun getAllCachedCountries(): Flow<StateAction>
    suspend fun insertLocalCountry(country: List<CountryEntity>): Flow<StateAction>
}

class RoomDataSource @Inject constructor(
    private val countryDao: CountryDao
) : LocalDataSource {

    override suspend fun getAllCachedCountries() = flow {
        emit(StateAction.MESSAGE("Loading from cache"))
        val cache = countryDao.getAllCachedCountries()
        try {
            if (cache.isNotEmpty()) {
                cache.let { result ->
                    countryDao.deleteAllCountryLocalItem()
                    emit(StateAction.SUCCESS(result.map { it.toDomainModel() }))
                }
            } else {
                throw FailedCache()

            }
        } catch (e: Exception) {
            emit(StateAction.ERROR(e))
        }
    }

    override suspend fun insertLocalCountry(country: List<CountryEntity>) = flow {
        try {
            emit(StateAction.SUCCESS(country.fromDomainModel()))
        }catch (e: Exception) {
            emit(StateAction.ERROR(e))
        }

    }


}

//private fun List<Country>.fromDomainModel(): List<CountryEntity> = map {
//    it.fromDomainModel()
//}

private fun List<CountryEntity>.fromDomainModel(): List<Country> = map {
    it.fromDomainModel()
}

private fun List<CountryEntity>.toDomainModel(): List<Country> = map { it.toDomainModel() }

private fun CountryEntity.toDomainModel(): Country = Country(
    capital,
    code,
    name,
    region
)
private fun CountryEntity.fromDomainModel(): Country = Country(
    capital,
    code,
    name,
    region
)

//private fun Country.fromDomainModel(): CountryEntity = CountryEntity(
//    capital,
//    code,
//    name,
//    region
//)





