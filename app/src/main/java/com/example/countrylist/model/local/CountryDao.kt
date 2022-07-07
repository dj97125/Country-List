package com.example.countrylist.model.local


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocalCountry(country: List<CountryEntity>)

    @Query("DELETE FROM country_item")
    suspend fun deleteAllCountryLocalItem()

    @Query("SELECT * FROM country_item order by name")
    suspend fun getAllCachedCountries(): List<CountryEntity>

}