package com.example.countrylist.common

sealed class StateAction {
    object LOADING : StateAction()
    class SUCCESS<T>(val response: T) : StateAction()
    class ERROR(val error: Exception) : StateAction()
    class MESSAGE(val text: String) : StateAction()
}