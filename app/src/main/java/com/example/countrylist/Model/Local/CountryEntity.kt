package com.example.countrylist.Model.Local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.countrylist.Model.Network.CountryResponse.Currency
import com.example.countrylist.Model.Network.CountryResponse.Language
@Entity(tableName = "country_item")
data class CountryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "capital")
    val capital: String,
    @ColumnInfo(name = "code")
    val code: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "region")
    val region: String
)
