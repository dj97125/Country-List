package com.example.countrylist.domain

import com.example.countrylist.model.network.CountryRepository.NetworkRepository
import javax.inject.Inject

class UseCase @Inject constructor(
    private val repository: NetworkRepository
) {
    operator fun invoke() = repository.countryList()

}