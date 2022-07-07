package com.example.countrylist.model.network.country_response


import com.google.gson.annotations.SerializedName

data class Currency(
    @SerializedName("code")
    val code: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("symbol")
    val symbol: String?
)