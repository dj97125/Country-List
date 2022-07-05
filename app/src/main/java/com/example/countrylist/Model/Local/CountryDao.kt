package com.example.countrylist.Model.Local


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountryDao {

    @Query("SELECT * FROM country_item")
    suspend fun getAllCachedCountries(): List<CountryEntity>

    @Query("DELETE FROM country_item")
    suspend fun deleteAllCountryLocalItem()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocalCountry(country: List<CountryEntity>)



}