package com.example.countrylist.common

import com.example.countrylist.model.local.CountryEntity
import com.example.countrylist.model.network.country_response.CountriesResponseItem

fun CountriesResponseItem.toDomain() = CountriesResponseItem(capital, code, name, region)
fun CountryEntity.toDomain() = CountriesResponseItem(capital, code, name, region)
fun CountriesResponseItem.toDatabase() =
    CountryEntity(
        capital = capital,
        code = code,
        name = name,
        region = region

    )