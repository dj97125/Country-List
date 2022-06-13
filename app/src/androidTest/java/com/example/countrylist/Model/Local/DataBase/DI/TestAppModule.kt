package com.example.countrylist.Model.Local.DataBase.DI

import android.content.Context
import androidx.room.Room
import com.example.countrylist.Common.DATABASE_NAME
import com.example.countrylist.Model.Local.DataBase.CountryDataBase
import com.example.countrylist.di.RoomModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TestAppModule {

    @Provides
    @Named("test_db")
    fun provideInMemoryDb(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, CountryDataBase::class.java, DATABASE_NAME).build()

}