package com.example.countrylist.model.local

import com.example.countrylist.common.FailedCache
import com.example.countrylist.common.StateAction
import com.example.countrylist.domain.Country
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.example.countrylist.model.local.CountryEntity as DbCountry

interface LocalDataSource {
    fun getAllCachedCountries(): Flow<StateAction>
    fun insertLocalCountry(country: List<Country>): Flow<Unit>
}

class RoomDataSource @Inject constructor(
    private val countryDao: CountryDao
) : LocalDataSource {

    override fun getAllCachedCountries(): Flow<StateAction> = flow {
        val cache = countryDao.getAllCachedCountries()
            emit(StateAction.SUCCESS(cache.map { it.toDomainModel() }))
    }

    override fun insertLocalCountry(country: List<Country>): Flow<Unit> = flow {
        countryDao.insertLocalCountry(country.fromDomainModel())
    }

}

private fun List<DbCountry>.toDomainModel(): List<Country> = map {
    it.toDomainModel()
}

private fun List<Country>.fromDomainModel(): List<DbCountry> = map {
    it.fromDomainModel()
}

private fun DbCountry.toDomainModel(): Country = Country(
    capital,
    code,
    name,
    region
)

private fun Country.fromDomainModel(): DbCountry = DbCountry(
    id = 0,
    capital,
    code,
    name,
    region
)






