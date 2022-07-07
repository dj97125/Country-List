package com.example.countrylist.di

import android.content.Context
import androidx.room.Room
import com.example.countrylist.common.BASE_URL
import com.example.countrylist.common.DATABASE_NAME
import com.example.countrylist.model.local.CountryDao
import com.example.countrylist.model.local.CountryDataBase
import com.example.countrylist.model.network.NetworkAPI
import com.example.countrylist.model.network.CountryRepository.NetworkRepository
import com.example.countrylist.model.network.CountryRepository.NetworkRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
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
class ServiceModule {

    @Singleton
    @Provides
    fun provideNycService(): NetworkAPI =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
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
    fun provideRoom(@ApplicationContext context: Context): CountryDataBase =
        Room.databaseBuilder(context, CountryDataBase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideCountryDao(dataBase: CountryDataBase): CountryDao = dataBase.countryDao()
}

@Module()
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {

    @Binds
    @ViewModelScoped
    abstract fun bindRepositoryLayer(
        networkRepositoryImpl: NetworkRepositoryImpl
    ): NetworkRepository

}