package com.iodroid.currencysort.networking.response.model

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyResponse(
    var date: String? = null,
    var aud: Aud? = Aud()
)
