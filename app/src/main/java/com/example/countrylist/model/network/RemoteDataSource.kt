package com.example.countrylist.model.network

import android.util.Log
import com.example.countrylist.common.FailedResponseException
import com.example.countrylist.common.NullResponseException
import com.example.countrylist.common.StateAction
import com.example.countrylist.domain.Country
import com.example.countrylist.model.network.country_response.CountriesResponseItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface RemoteDataSource {
    fun countryCached(): Flow<StateAction>
}

class ServiceDataSource @Inject constructor(
    private val service: NetworkAPI
) : RemoteDataSource {

    override fun countryCached(): Flow<StateAction> = flow {
        val service = service.getCountriesList()
        if (service.isSuccessful) {
            service.body()?.let { result ->
                emit(StateAction.SUCCESS(result.map { it.toDomainModel() }))
            } ?: throw NullResponseException()
        } else {
            throw FailedResponseException()
        }
    }

}


private fun List<CountriesResponseItem>.toDomainModel(): List<Country> = map {
    it.toDomainModel()
}

private fun CountriesResponseItem.toDomainModel(): Country =
    Country(capital, code, name, region)
