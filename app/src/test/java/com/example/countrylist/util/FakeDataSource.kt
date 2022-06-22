package com.example.countrylist.util




class FakeDataSource(var countries: MutableList<CountriesResponseItem>? = mutableListOf()):NetworkAPI {

    override suspend fun getCountriesList(): Response<List<CountriesResponseItem>> {
        countries?.let{ it ->
            return Response.success(ArrayList(it)) }

    }


}