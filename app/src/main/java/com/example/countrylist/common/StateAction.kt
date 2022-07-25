package com.example.countrylist.common

sealed class StateAction() {
    class SUCCESS<T>(val response: T) : StateAction()
    class ERROR(val error: Throwable) : StateAction()
    class MESSAGE(val text: String) : StateAction()
}