package com.example.countrylist.common

sealed class StateAction() {
    class SUCCESS<T>(val response: T, val message: String) : StateAction()
    class ERROR(val error: Throwable) : StateAction()
}