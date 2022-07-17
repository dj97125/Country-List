package com.example.countrylist.domain.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.countrylist.databinding.CountriesListCardViewBinding
import com.example.countrylist.domain.Country
import com.example.countrylist.model.local.CountryEntity


class CountryListAdapter(
    private val countries: MutableList<Country> = mutableListOf()
) : RecyclerView.Adapter<CountryListAdapter.NetworkViewHolder>() {


    fun updateData(country: List<Country>) {
        countries.clear()
        countries.addAll(country)
        notifyDataSetChanged()
    }

    class NetworkViewHolder(private val binding: CountriesListCardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(country: Country) {
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