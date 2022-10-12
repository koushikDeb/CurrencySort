package com.iodroid.currencysort.ui.main

import androidx.lifecycle.ViewModel
import com.iodroid.currencysort.repository.Repo
import com.iodroid.currencysort.repository.domain.model.CurrencyNode
import java.util.LinkedList

class MainViewModel : ViewModel() {
    suspend fun fetchCurrencies(): LinkedList<CurrencyNode> {
        Repo().getCurrenciesLinkedList()?.let { list ->
            return sort(list)
        } ?: kotlin.run {
            return LinkedList()
        }
    }

    fun sort(list: LinkedList<CurrencyNode>): LinkedList<CurrencyNode> {
        for (pass in 0 until (list.size - 1)) {
            for (currentPosition in 0 until (list.size - 1)) {
                if (list[currentPosition].currencyValue > list[currentPosition + 1].currencyValue) {
                    val tmp = list[currentPosition]
                    list[currentPosition] = list[currentPosition + 1]
                    list[currentPosition + 1] = tmp
                } else if (list[currentPosition].currencyValue == list[currentPosition + 1].currencyValue) {
                    if (list[currentPosition].currencyId.compareTo(list[currentPosition + 1].currencyId) > 0) {
                        val tmp = list[currentPosition]
                        list[currentPosition] = list[currentPosition + 1]
                        list[currentPosition + 1] = tmp }
                }
            }
        }
        return list
    }
}
