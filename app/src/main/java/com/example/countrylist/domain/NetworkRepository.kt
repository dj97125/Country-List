package com.example.countrylist.model.network.CountryRepository


import com.example.countrylist.common.InternetCheck
import com.example.countrylist.common.StateAction
import com.example.countrylist.domain.Country
import com.example.countrylist.model.local.LocalDataSource
import com.example.countrylist.model.network.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface NetworkRepository {
    fun countryList(): Flow<StateAction>
}

class NetworkRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : NetworkRepository {


    override fun countryList(): Flow<StateAction> = flow {
        val connected = InternetCheck()
        val remoteService = remoteDataSource.countryCached()
        if (connected.isConnected()) {
            remoteService.collect() { stateAction ->
                when (stateAction) {
                    is StateAction.SUCCESS<*> -> {
                        val retrievedCountries = stateAction.response as List<Country>
                        emit(StateAction.SUCCESS(retrievedCountries))
                        localDataSource.insertLocalCountry(retrievedCountries).collect()
                        //localDataSource.deleteAllCountryLocalItem()


                    }
                }
            }
        } else {
            val cache = localDataSource.getAllCachedCountries()
            cache.collect() { stateAction ->
                when (stateAction) {
                    is StateAction.SUCCESS<*> -> {
                        val retrievedCountries = stateAction.response as List<Country>
                        emit(StateAction.SUCCESS(retrievedCountries))
                    }
                }

            }


        }
    }
}


