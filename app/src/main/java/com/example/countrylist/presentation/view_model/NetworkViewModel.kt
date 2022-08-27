package com.example.countrylist.presentation.view_model

import androidx.lifecycle.ViewModel
import com.example.countrylist.common.StateAction
import com.example.countrylist.domain.Country
import com.example.countrylist.domain.UseCase
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
    private val useCase: UseCase,
    private val coroutineScope: CoroutineScope,
    private val handler: CoroutineExceptionHandler
) : ViewModel() {

    private val _countryResponse: MutableStateFlow<StateAction?> =
        MutableStateFlow(null)
    val countryResponse: StateFlow<StateAction?>
        get() = _countryResponse.asStateFlow()


    init {
        getCountryList()
    }


    fun getCountryList() {
        coroutineScope.launch(handler) {
            supervisorScope {
                launch {
                    useCase().collect() { stateAction ->
                        when (stateAction) {
                            is StateAction.SUCCESS<*> -> {
                                val retrievedMessage = stateAction.message
                                val retrievedCountries = stateAction.response as List<Country>
                                _countryResponse.value = StateAction.SUCCESS(retrievedCountries,retrievedMessage)
                            }
                            is StateAction.ERROR -> {
                                val retrievedError = stateAction.error
                                _countryResponse.value = StateAction.ERROR(retrievedError)
                            }

                        }
                    }
                }

            }

        }
    }
}








