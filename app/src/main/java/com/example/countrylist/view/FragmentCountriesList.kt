package com.example.countrylist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countrylist.common.BaseFragment
import com.example.countrylist.common.StateAction
import com.example.countrylist.domain.Adapters.CountryListAdapter
import com.example.countrylist.model.network.country_response.CountriesResponseItem
import com.example.countrylist.databinding.FragmentCountriesListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentCountriesList : BaseFragment() {

    private val binding by lazy {
        FragmentCountriesListBinding.inflate(layoutInflater)
    }

    private val networkAdapter by lazy {
        CountryListAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.VERTICAL,
                false
            )

            adapter = networkAdapter
        }
        networkViewModel.countryResponse.observe(viewLifecycleOwner) { state ->
            when (state) {
                is StateAction.LOADING -> {
                    showToastMessage("Loading...")
                    binding.recyclerView.visibility = View.GONE
                    binding.swipeRefresh.visibility = View.GONE
                }
                is StateAction.SUCCESS<*> -> {
                    val retrievedCountries = state.response as List<CountriesResponseItem>

                    retrievedCountries.let {
                        networkAdapter.updateData(it)
                    }

                    binding.recyclerView.visibility = View.VISIBLE
                    binding.swipeRefresh.visibility = View.VISIBLE


                }
                is StateAction.ERROR -> {
                    binding.recyclerView.visibility = View.GONE
                    binding.swipeRefresh.visibility = View.GONE

                    displayErrors(state.error.localizedMessage) {
                        networkViewModel.getCountryList()
                    }
                }
            }

        }
        //networkViewModel.getCountryList()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.swipeRefresh.apply {
            setColorSchemeResources(
                android.R.color.holo_blue_dark,
                android.R.color.holo_purple,
                android.R.color.holo_orange_dark,
                android.R.color.holo_blue_bright,
                android.R.color.holo_red_light,
                android.R.color.holo_green_dark,
            )
            setOnRefreshListener {
                networkViewModel.getCountryList()
                binding.swipeRefresh.isRefreshing = false
            }

        }

    }


}