package com.example.countrylist.di

import android.content.Context
import androidx.room.Room
import com.example.countrylist.common.BASE_URL
import com.example.countrylist.common.BASE_URL_TESTING
import com.example.countrylist.model.local.CountryDataBase
import com.example.countrylist.model.network.NetworkAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [ServiceModule::class,
        ViewModelBindModule::class,
        RepositoryBindModule::class
    ]
)
object TestAppModule {

    @Provides
    @Singleton
    @ApiUrl
    fun provideUrl(): String = BASE_URL_TESTING

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

    @Provides
    @Singleton
    @TestDB
    fun provideInMemoryDb(@ApplicationContext context: Context): CountryDataBase = Room.inMemoryDatabaseBuilder(
        context,
        CountryDataBase::class.java
    ).allowMainThreadQueries().build()

    @Provides
    @Singleton
    fun provideCountryDao(@TestDB dataBase: CountryDataBase) = dataBase.countryDao()

}