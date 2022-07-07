package com.example.countrylist.model.network

import com.example.countrylist.common.END_POINT_COUNTRIES
import com.example.countrylist.model.network.country_response.CountriesResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface NetworkAPI {

    @GET(END_POINT_COUNTRIES)
    suspend fun getCountriesList(): Response<List<CountriesResponseItem>>
}