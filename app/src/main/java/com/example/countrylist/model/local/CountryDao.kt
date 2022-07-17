package com.example.countrylist.model.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocalCountry(countryEntity: List<CountryEntity>)

    @Query("DELETE FROM CountryEntity")
    suspend fun deleteAllCountryLocalItem()

    @Query("SELECT * FROM CountryEntity order by name")
    suspend fun getAllCachedCountries(): List<CountryEntity>

}