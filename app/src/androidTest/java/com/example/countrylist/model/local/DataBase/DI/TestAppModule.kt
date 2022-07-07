package com.example.countrylist.model.local.DataBase.DI

import android.content.Context
import androidx.room.Room
import com.example.countrylist.common.DATABASE_NAME
import com.example.countrylist.model.local.CountryDataBase
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