package com.example.countrylist.Model.Network.CountryResponse



data class CountriesResponseItem(
    val capital: String,
    val code: String,
    val name: String,
    val region: String
)
