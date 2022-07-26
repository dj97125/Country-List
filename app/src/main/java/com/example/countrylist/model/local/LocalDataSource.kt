package com.example.countrylist.model.local

import android.util.Log
import com.example.countrylist.common.NullResponseException
import com.example.countrylist.common.StateAction
import com.example.countrylist.di.ProductionDB
import com.example.countrylist.domain.Country
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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
        cache.let {
            emit(StateAction.SUCCESS(cache.map { it.toDomainModel() }))
            Log.d("LocalDataSource", "getAllCountries: $it")
        }



    }

    override suspend fun insertLocalCountry(country: List<Country>): Flow<StateAction> = flow {
        countryDao.insertLocalCountry(country.fromDomainModel())
        Log.d("LocalDataSource", "insertLocalCountry: ${country.size}")

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
    capital = capital,
    code = code,
    name = name,
    region = region
)

private fun Country.fromDomainModel(): CountryEntity = CountryEntity(
    id = 0,
    capital = capital,
    code = code,
    name = name,
    region = region
)






