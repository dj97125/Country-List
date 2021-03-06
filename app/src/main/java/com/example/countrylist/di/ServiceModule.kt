package com.example.countrylist.di

import android.content.Context
import androidx.room.Room
import com.example.countrylist.common.BASE_URL
import com.example.countrylist.common.DATABASE_NAME
import com.example.countrylist.model.local.CountryDao
import com.example.countrylist.model.local.CountryDataBase
import com.example.countrylist.model.local.LocalDataSource
import com.example.countrylist.model.local.RoomDataSource
import com.example.countrylist.model.network.CountryRepository.NetworkRepository
import com.example.countrylist.model.network.CountryRepository.NetworkRepositoryImpl
import com.example.countrylist.model.network.NetworkAPI
import com.example.countrylist.model.network.RemoteDataSource
import com.example.countrylist.model.network.ServiceDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    @ApiUrl
    fun provideUrl(): String = BASE_URL

    @Singleton
    @Provides
    fun provideNycService(@ApiUrl apiUrl : String): NetworkAPI =
        Retrofit.Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
            .create(NetworkAPI::class.java)


    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    @Singleton
    @Provides
    fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Singleton
    @Provides
    fun provideCoroutineScope(dispatcher: CoroutineDispatcher): CoroutineScope =
        CoroutineScope(dispatcher)

    @Singleton
    @Provides
    @ProductionDB
    fun provideRoom(@ApplicationContext context: Context): CountryDataBase =
        Room.databaseBuilder(
            context,
            CountryDataBase::class.java, DATABASE_NAME
        ).fallbackToDestructiveMigration().build()


    @Singleton
    @Provides
    fun provideCountryDao(@ProductionDB dataBase: CountryDataBase) = dataBase.countryDao()

}

@Module()
@InstallIn(ViewModelComponent::class)
abstract class ViewModelBindModule {

    @Binds
    abstract fun bindRepository(
        networkRepositoryImpl: NetworkRepositoryImpl
    ): NetworkRepository


}

@Module()
@InstallIn(SingletonComponent::class)
abstract class RepositoryBindModule {

    @Binds
    abstract fun bindLocalDataSource(
        roomDataSource: RoomDataSource
    ): LocalDataSource

    @Binds
    abstract fun bindRemoteDataSource(
        serviceDataSource: ServiceDataSource
    ): RemoteDataSource

}