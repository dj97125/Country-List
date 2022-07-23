package com.example.countrylist.model.local.DataBase.DI

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.countrylist.common.DATABASE_NAME
import com.example.countrylist.di.ProductionDB
import com.example.countrylist.di.ServiceModule
import com.example.countrylist.model.local.CountryDao
import com.example.countrylist.model.local.CountryDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Named
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [ServiceModule::class]
)
object TestAppModule {

    @Provides
    @Singleton
    @TestDB
    fun provideInMemoryDb(app: Application) = Room.inMemoryDatabaseBuilder(
        app,
        CountryDataBase::class.java
    ).allowMainThreadQueries().build()

    @Singleton
    @Provides
    fun provideCountryDao(@TestDB dataBase: CountryDataBase) = dataBase.countryDao()

}