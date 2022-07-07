package com.example.countrylist.domain.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countrylist.model.network.country_response.CountriesResponseItem
import com.example.countrylist.databinding.CountriesListCardViewBinding


class CountryListAdapter(
    private val countries: MutableList<CountriesResponseItem> = mutableListOf()
) : RecyclerView.Adapter<CountryListAdapter.NetworkViewHolder>() {


    fun updateData(newSchools: List<CountriesResponseItem>) {
        countries.clear()
        countries.addAll(newSchools)
        notifyDataSetChanged()
    }

    class NetworkViewHolder(private val binding: CountriesListCardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(country: CountriesResponseItem) {
            binding.tvCountryName.text = country.name
            binding.tvCountryCapital.text = country.capital
            binding.tvCountryCode.text = country.code
            binding.tvCountryRegion.text = country.region

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NetworkViewHolder {
        return NetworkViewHolder(
            CountriesListCardViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = countries.size

    override fun onBindViewHolder(holder: NetworkViewHolder, position: Int) =
        holder.bind(countries[position])

}