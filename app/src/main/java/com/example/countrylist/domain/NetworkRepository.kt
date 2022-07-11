package com.example.countrylist.model.network.CountryRepository


import com.example.countrylist.common.InternetCheck
import com.example.countrylist.common.StateAction
import com.example.countrylist.model.local.LocalDataSource
import com.example.countrylist.model.network.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface NetworkRepository {
    suspend fun countryList(): Flow<StateAction>
}

class NetworkRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : NetworkRepository {


    override suspend fun countryList() = flow {
        val connected = InternetCheck()
        if (connected.isConnected()) {
            val remoteService = remoteDataSource.countryCached()
            remoteService.collect { stateAction ->
                when (stateAction) {
                    is StateAction.SUCCESS<*> -> {
                        remoteDataSource.countryCached()
                        localDataSource.insertLocalCountry(stateAction)
                    }

                    is StateAction.ERROR -> {
                        localDataSource.getAllCachedCountries()
                    }
                }
            }
        }

    }
}