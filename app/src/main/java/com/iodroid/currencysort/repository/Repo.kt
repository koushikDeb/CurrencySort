package com.iodroid.currencysort.repository

import com.iodroid.currencysort.CURRENCY_URL
import com.iodroid.currencysort.networking.KtorClient
import com.iodroid.currencysort.repository.ResponseTOLinkedListMapper.mapToLinkedList
import com.iodroid.currencysort.repository.domain.model.CurrencyNode
import io.ktor.client.request.get
import io.ktor.client.request.url
import java.util.LinkedList

class Repo {
    suspend fun getCurrenciesLinkedList(): LinkedList<CurrencyNode>? {
        return mapToLinkedList(
            KtorClient.httpClient.get {
                url(CURRENCY_URL)
            }
        )
    }
}
