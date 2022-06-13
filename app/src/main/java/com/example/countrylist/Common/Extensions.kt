package com.example.countrylist.Common

import com.example.countrylist.Model.Local.Entities.CountryEntity
import com.example.countrylist.Model.Network.CountryResponse.CountriesResponseItem

fun CountriesResponseItem.toDomain() = CountriesResponseItem(capital, code, name, region)
fun CountryEntity.toDomain() = CountriesResponseItem(capital, code, name, region)
fun CountriesResponseItem.toDatabase() =
    CountryEntity(
        capital = capital,
        code = code,
        name = name,
        region = region

    )