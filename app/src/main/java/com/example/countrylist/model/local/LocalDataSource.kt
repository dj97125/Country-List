package com.example.countrylist.model.local

import android.util.Log
import com.example.countrylist.common.StateAction
import com.example.countrylist.domain.Country
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

interface LocalDataSource {
    fun getAllCachedCountries(): Flow<StateAction>
    suspend fun insertLocalCountry(country: List<Country>): Flow<StateAction>
    suspend fun deleteAllCountryLocalItem()
}

class RoomDataSource @Inject constructor(
    private val countryDao: CountryDao
) : LocalDataSource {

    override fun getAllCachedCountries(): Flow<StateAction> = flow {
        val cache = countryDao.getAllCachedCountries()
        if (cache.isNotEmpty()) {
            emit(StateAction.SUCCESS(cache.map { it.toDomainModel() }))
        }
    }

    override suspend fun insertLocalCountry(country: List<Country>): Flow<StateAction> = flow {
        emit(StateAction.SUCCESS(country))
    }.onEach {
//        val countries = it.response
//        countryDao.insertLocalCountry(countries.fromDomainModel())

        StateAction.SUCCESS(countryDao.insertLocalCountry(it.response.fromDomainModel()))
//        Log.d("LOcal", "insertLocalCountry: $countries")

    }

    override suspend fun deleteAllCountryLocalItem() {
        return countryDao.deleteAllCountryLocalItem()
    }


}

private fun List<CountryEntity>.toDomainModel(): List<Country> = map {
    it.toDomainModel()
}

private fun List<Country>.fromDomainModel(): List<CountryEntity> = map {
    it.fromDomainModel()
}

private fun CountryEntity.toDomainModel(): Country = Country(
    capital,
    code,
    name,
    region
)

private fun Country.fromDomainModel(): CountryEntity = CountryEntity(
    capital,
    code,
    name,
    region
)






