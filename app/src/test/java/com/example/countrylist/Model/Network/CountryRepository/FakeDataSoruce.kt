package com.example.countrylist.Model.Network.CountryRepository

import com.example.countrylist.Common.StateAction
import com.example.countrylist.Common.toDomain
import com.example.countrylist.Model.Network.CountryResponse.CountriesResponseItem
import kotlinx.coroutines.flow.Flow

//class FakeDataSoruce(var countries: MutableList<CountriesResponseItem>? = mutableListOf()):NetworkRepository {
////    override suspend fun countryCached(): Flow<StateAction> {
////        countries?.let { return emit(StateAction.SUCCESS(it)) }
////    }
//}