package com.example.countrylist.di

import android.content.Context
import androidx.room.Room
import com.example.countrylist.Common.DATABASE_NAME
import com.example.countrylist.Model.Local.Dao.CountryDao
import com.example.countrylist.Model.Local.DataBase.CountryDataBase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): CountryDataBase =
        Room.databaseBuilder(context, CountryDataBase::class.java, DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideCountryDao(dataBase: CountryDataBase): CountryDao = dataBase.countryDao()
}