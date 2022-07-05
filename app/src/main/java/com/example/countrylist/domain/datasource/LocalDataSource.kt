package com.example.countrylist.domain.datasource

import com.example.countrylist.Common.StateAction
import com.example.countrylist.Model.Local.CountryEntity

interface LocalDataSource {

    suspend fun getAllCachedCountries(): List<CountryEntity>

    suspend fun deleteAllCountryLocalItem()

    suspend fun insertLocalCountry(country: List<CountryEntity>)
}