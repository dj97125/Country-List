package com.example.countrylist.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countrylist.common.BaseFragment
import com.example.countrylist.common.StateAction
import com.example.countrylist.databinding.FragmentCountriesListBinding
import com.example.countrylist.presentation.adapters.CountryListAdapter
import com.example.countrylist.domain.Country
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

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

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                networkViewModel.countryResponse.collect { state ->
                    when (state) {
                        is StateAction.SUCCESS<*> -> {
                            val retrievedMessage = state.message
                            val retrievedCountries = state.response as List<Country>
                            showToastMessage(retrievedMessage)
                            networkAdapter.updateData(retrievedCountries)

                            binding.recyclerView.visibility = View.VISIBLE
                            binding.swipeRefresh.visibility = View.VISIBLE
                            binding.progressBar.visibility = View.GONE


                        }
                        is StateAction.ERROR -> {
                            binding.recyclerView.visibility = View.GONE
                            binding.swipeRefresh.visibility = View.GONE
                            binding.progressBar.visibility = View.GONE

                            displayErrors(state.error.localizedMessage) {
                                networkViewModel.getCountryList()
                            }
                        }
                    }
                }
            }

        }

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