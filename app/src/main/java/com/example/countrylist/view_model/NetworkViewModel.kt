package com.example.countrylist.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.countrylist.common.StateAction
import com.example.countrylist.domain.Country
import com.example.countrylist.model.network.CountryRepository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

@HiltViewModel
class NetworkViewModel @Inject constructor(
    private val repository: NetworkRepository,
    private val coroutineScope: CoroutineScope
) : ViewModel() {

    private val _countryResponse: MutableStateFlow<StateAction?> = MutableStateFlow(null)
    val countryResponse: StateFlow<StateAction?>
        get() = _countryResponse.asStateFlow()


    init {
        getCountryList()
    }

    fun getCountryList() {
        val handler = CoroutineExceptionHandler { _, throwable ->
            Log.d("ViewModel", "$throwable")
        }
        coroutineScope.launch(handler) {
            supervisorScope {
                launch {
                    repository.countryList().collect { stateAction ->
                        when (stateAction) {
                            is StateAction.SUCCESS<*> -> {
                                val retrievedCountries = stateAction.response as List<Country>
                                _countryResponse.value = StateAction.SUCCESS(retrievedCountries)
                            }
                        }
                    }
                }

            }

        }
    }


}

//    fun getCountryList() {
//        coroutineScope.launch {
////            _countryResponse.value = StateAction.SUCCESS("US")
////            Log.d("ViewModel", "_countryResponse: ${_countryResponse.value}")
//            repository.countryList().collect {
//                _countryResponse.value = StateAction.SUCCESS(it)
//                Log.d("ViewModel", "_country: ${_countryResponse.value}")
//                Log.d("ViewModel", "country: $countryResponse")
//                Log.d("ViewModel", "it: $it")
//            }
//        }
//    }

//    fun getCountryList() {
//        coroutineScope.launch {
//            repository.countryList().collect { stateAction ->
//                when (stateAction) {
//                    is StateAction.SUCCESS<*> -> {
//                        val retrievedCountries = stateAction.response as List<Country>
//
//                        retrievedCountries.let{ country ->
//                            _countryResponse.value = StateAction.SUCCESS(country)
//                            Log.d("ViewModel", "country: $country")
//                        }
//
//                        _countryResponse.value = StateAction.SUCCESS(retrievedCountries)
//                        Log.d("ViewModel", "retrievedCountries: $retrievedCountries")
//
//
//                    }
//                    is StateAction.ERROR -> {
//
//                    }
//                }
//            }
//        }
//    }



