package com.example.countrylist.Model.Network

import com.example.countrylist.Common.END_POINT_COUNTRIES
import com.example.countrylist.Model.Network.CountryResponse.CountriesResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface NetworkAPI {

    @GET(END_POINT_COUNTRIES)
    suspend fun getCountriesList(): Response<List<CountriesResponseItem>>
}