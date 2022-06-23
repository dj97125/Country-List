package com.example.countrylist.di

import com.example.countrylist.Model.Local.Dao.CountryDao
import com.example.countrylist.Model.Local.DataBase.CountryDataBase
import com.example.countrylist.Model.Network.CountryRepository.NetworkRepository
import com.example.countrylist.Model.Network.CountryRepository.NetworkRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNetworkRepository(
        networkRepositoryImpl: NetworkRepositoryImpl
    ): NetworkRepository

//    @Binds
//    @Singleton
//    abstract fun provideCountryDao(dataBase: CountryDataBase): CountryDao


}