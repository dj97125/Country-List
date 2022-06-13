package com.example.countrylist.Model.Local.DataBase


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.countrylist.Model.Local.Dao.CountryDao
import com.example.countrylist.Model.Local.Entities.CountryEntity
import kotlinx.coroutines.InternalCoroutinesApi


@Database(
    version = 1,
    entities = [CountryEntity::class],
    exportSchema = false
)

abstract class CountryDataBase : RoomDatabase() {
    abstract fun countryDao(): CountryDao

    companion object {

        @Volatile
        private var INSTANCE: CountryDataBase? = null

        @InternalCoroutinesApi
        fun getInstance(context: Context): CountryDataBase {

            kotlinx.coroutines.internal.synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    CountryDataBase::class.java,
                    "country_db"
                ).build().also {
                    INSTANCE = it
                }

            }
        }
    }
}