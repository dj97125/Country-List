package com.example.countrylist.Model.Local.Dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.countrylist.Model.Local.Entities.CountryEntity

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocalCountry(country: List<CountryEntity>)

    @Query("DELETE FROM country_item")
    suspend fun deleteAllCountryLocalItem()

    @Query("SELECT * FROM country_item order by name")
    suspend fun getAllCachedCountries(): List<CountryEntity>

}