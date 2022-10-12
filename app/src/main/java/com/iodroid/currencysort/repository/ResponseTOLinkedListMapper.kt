package com.iodroid.currencysort.repository

import com.iodroid.currencysort.OBJECT_KEY
import com.iodroid.currencysort.repository.domain.model.CurrencyNode
import org.json.JSONObject
import java.util.LinkedList

object ResponseTOLinkedListMapper {
    fun mapToLinkedList(response: String): LinkedList<CurrencyNode> {
        val responseLinkedList: LinkedList<CurrencyNode> = LinkedList()
        JSONObject(response).get(OBJECT_KEY).apply {
            if (this is JSONObject) {
                keys().forEachRemaining { key ->
                    get(key).let { value ->
                        responseLinkedList.add(CurrencyNode(key, value.toString().toDouble()))
                    }
                }
            }
        }
        return responseLinkedList
    }
}
