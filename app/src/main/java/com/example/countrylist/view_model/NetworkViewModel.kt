package com.example.countrylist.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.countrylist.common.StateAction

import com.example.countrylist.model.network.CountryRepository.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NetworkViewModel @Inject constructor(
    private val repository: NetworkRepository,
    private val coroutineScope: CoroutineScope,
) : ViewModel() {

    private val _countryResponse = MutableLiveData<StateAction>()
    val countryResponse: MutableLiveData<StateAction>
        get() = _countryResponse

    init {
        getCountryList()
    }

    fun getCountryList() {
        coroutineScope.launch {
            repository.countryCached().collect {
                _countryResponse.postValue(it)
            }
        }
    }
}


