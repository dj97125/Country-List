package com.example.countrylist.Model.Local.DataBase.DI

import android.content.Context
import androidx.room.Room
import com.example.countrylist.Common.DATABASE_NAME
import com.example.countrylist.Model.Local.CountryDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
class TestAppModule {

    @Provides
    @Named("test_db")
    fun provideInMemoryDb(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, CountryDataBase::class.java, DATABASE_NAME).build()

}