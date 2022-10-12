package com.iodroid.currencysort.ui.main

import androidx.lifecycle.ViewModel
import com.iodroid.currencysort.repository.Repo
import com.iodroid.currencysort.repository.domain.model.CurrencyNode
import com.iodroid.currencysort.utils.Converters.convertLinkListToSortedList
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.LinkedList
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: Repo) : ViewModel() {
    suspend fun fetchCurrencies(): LinkedList<CurrencyNode> {
        repo.getCurrenciesLinkedList()?.let { list ->
            return convertLinkListToSortedList(list)
        } ?: kotlin.run {
            return LinkedList()
        }
    }
}
