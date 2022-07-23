package com.example.countrylist.common

sealed class StateAction() {
    object LOADING : StateAction()
    class SUCCESS<T>(val response: T) : StateAction()
    class ERROR(val error: Throwable) : StateAction()
}