package com.example.countrylist.common

class NullResponseException(
    message: String = "Response is null"
) : Exception(message)

class FailedResponseException(
    message: String = "Error: failure in the response"
) : Exception(message)

class FailedCache(
    message: String = "Error: failure in the cache"
) : Exception(message)

