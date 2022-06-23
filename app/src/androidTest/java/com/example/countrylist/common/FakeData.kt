package com.example.countrylist.common

import com.example.countrylist.Model.Local.Entities.CountryEntity
import com.example.countrylist.Model.Network.CountryResponse.CountriesResponseItem

object FakeData {

    val countriesNetwork = arrayOf(
        CountriesResponseItem("uno", "uno", "uno", "uno"),
        CountriesResponseItem("dos", "dos", "dos", "dos"),
        CountriesResponseItem("tres", "tres", "tres", "tres"),
    )

    val countriesLocal = arrayOf(
        CountryEntity(1,"uno", "uno", "uno", "uno"),
        CountryEntity(2,"dos", "dos", "dos", "dos"),
        CountryEntity(3,"tres", "tres", "tres", "tres")
    )
}