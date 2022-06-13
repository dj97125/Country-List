package com.example.countrylist.di

import com.example.countrylist.Common.BASE_URL
import com.example.countrylist.Model.Local.Dao.CountryDao
import com.example.countrylist.Model.Network.CountriesAPI.NetworkAPI
import com.example.countrylist.Model.Network.CountryRepository.NetworkRepository
import com.example.countrylist.Model.Network.CountryRepository.NetworkRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Singleton
    @Provides
    fun provideNycService(): NetworkAPI =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NetworkAPI::class.java)


    @Provides
    fun provideRepositoryLayer(service: NetworkAPI, dao: CountryDao): NetworkRepository =
        NetworkRepositoryImpl(service,dao)

    @Singleton
    @Provides
    fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Singleton
    @Provides
    fun provideCoroutineScope(dispatcher: CoroutineDispatcher): CoroutineScope =
        CoroutineScope(dispatcher)
}