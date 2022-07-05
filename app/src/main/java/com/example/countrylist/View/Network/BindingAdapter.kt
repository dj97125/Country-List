package com.example.countrylist.View.Network

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.countrylist.Model.Network.CountryResponse.CountriesResponseItem
import com.example.countrylist.domain.Adapters.CountryListAdapter

@BindingAdapter("items")
fun RecyclerView.setItems(country: List<CountriesResponseItem>?) {
    if (country != null) {
        (adapter as? CountryListAdapter)?.submitList(country)
    }
}