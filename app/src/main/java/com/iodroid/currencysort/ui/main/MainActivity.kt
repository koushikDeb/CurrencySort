package com.iodroid.currencysort.ui.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.iodroid.currencysort.repository.domain.model.CurrencyNode
import com.iodroid.currencysort.ui.theme.CurrencySortTheme
import com.iodroid.currencysort.ui.theme.Typography_Sort
import dagger.hilt.android.AndroidEntryPoint
import java.util.LinkedList

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencySortTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SortedCurrencyList()
                }
            }
        }
    }

    @Composable
    fun SortedCurrencyList() {
        val currencies = produceState(
            initialValue = LinkedList<CurrencyNode>(),
            producer = {
                value = mainViewModel.fetchCurrencies()
            }
        )
        if (currencies.value.size > 0) {
            LazyColumn(modifier = Modifier.fillMaxHeight().padding(16.dp)) {
                items(
                    itemContent = { item ->
                        CurrencyItems(
                            code = currencies.value[item].currencyId,
                            value = currencies.value[item].currencyValue.toString()
                        )
                    },
                    count = currencies.value.size
                )
            }
        } else {
            CustomCircularProgressBar()
        }
    }

    @Composable
    private fun CustomCircularProgressBar() {
        CircularProgressIndicator(
            modifier = Modifier.size(30.dp)
                .padding(100.dp),
            color = Color.Green,
            strokeWidth = 10.dp
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        CurrencySortTheme {
            SortedCurrencyList()
        }
    }

    @Composable
    fun CurrencyItems(code: String, value: String) {
        Button(
            onClick = {
                Toast.makeText(this, "Current value of $code is $value", Toast.LENGTH_LONG).show()
            },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            elevation = ButtonDefaults.elevation(defaultElevation = 20.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = Color.White
            ),
            shape = RoundedCornerShape(5.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = code.uppercase(), color = Color.LightGray, style = Typography_Sort.body1)
                Text(text = value, color = Color.Gray, style = Typography_Sort.body2)
            }
        }
    }
}
