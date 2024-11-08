package com.phuonnngminh.currencyconverter.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phuonnngminh.currencyconverter.data.models.Rates
import com.phuonnngminh.currencyconverter.util.DispatcherProvider
import com.phuonnngminh.currencyconverter.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.math.round

class MainViewModel @ViewModelInject constructor(
    private val repository: MainRepository,
    private val dispatchers: DispatcherProvider
): ViewModel() {

    sealed class CurrencyEvent {
        class Success(val resultText: String): CurrencyEvent()
        class Failure(val errorText: String): CurrencyEvent()
        object Loading : CurrencyEvent()
        object Empty : CurrencyEvent()
    }

    private val _conversion = MutableStateFlow<CurrencyEvent>(CurrencyEvent.Empty)
    val conversion: StateFlow<CurrencyEvent> = _conversion

    fun convert(
        amountStr: String,
        fromCurrency: String,
        toCurrency: String
    ) {
        val fromAmount = amountStr.toFloatOrNull()
        if (fromAmount == null) {
            _conversion.value = CurrencyEvent.Failure("Not a valid amount")
            return
        }

        viewModelScope.launch(dispatchers.io) {
            _conversion.value = CurrencyEvent.Loading

            when (val ratesResponse = repository.getRates("$fromCurrency,$toCurrency")) {
                is Resource.Error -> {
                    _conversion.value = CurrencyEvent.Failure(ratesResponse.message ?: "An unknown error occurred.")
                }
                is Resource.Success -> {
                    val rates = ratesResponse.data?.rates
                    if (rates == null) {
                        _conversion.value = CurrencyEvent.Failure("Rates not available.")
                        return@launch
                    }
                    val rateFromBaseToB = getRateForCurrency(toCurrency, rates) ?: 0.0
                    val rateFromBaseToA = getRateForCurrency(fromCurrency, rates) ?: 0.0

                    if (rateFromBaseToB == 0.0 || rateFromBaseToA == 0.0) {
                        _conversion.value = CurrencyEvent.Failure("Unexpected error: Currency rates not found.")
                    } else {

                        val amountInBase = fromAmount / rateFromBaseToA
                        val convertedCurrency = round(amountInBase * rateFromBaseToB * 100) / 100

                        val formattedConvertedCurrency = String.format("%.2f", convertedCurrency)

                        _conversion.value = CurrencyEvent.Success(
                            "$fromAmount $fromCurrency = $formattedConvertedCurrency $toCurrency"
                        )
                    }
                }
            }
        }
    }

    private fun getRateForCurrency(currency: String, rates: Rates) = when (currency) {
        "CAD" -> rates.cAD
        "HKD" -> rates.hKD
        "ISK" -> rates.iSK
        "EUR" -> rates.eUR
        "PHP" -> rates.pHP
        "DKK" -> rates.dKK
        "HUF" -> rates.hUF
        "CZK" -> rates.cZK
        "AUD" -> rates.aUD
        "RON" -> rates.rON
        "SEK" -> rates.sEK
        "IDR" -> rates.iDR
        "INR" -> rates.iNR
        "BRL" -> rates.bRL
        "RUB" -> rates.rUB
        "HRK" -> rates.hRK
        "JPY" -> rates.jPY
        "THB" -> rates.tHB
        "CHF" -> rates.cHF
        "SGD" -> rates.sGD
        "PLN" -> rates.pLN
        "BGN" -> rates.bGN
        "CNY" -> rates.cNY
        "NOK" -> rates.nOK
        "NZD" -> rates.nZD
        "ZAR" -> rates.zAR
        "USD" -> rates.uSD
        "MXN" -> rates.mXN
        "ILS" -> rates.iLS
        "GBP" -> rates.gBP
        "KRW" -> rates.kRW
        "MYR" -> rates.mYR
        "VND" -> rates.vND
        else -> null
    }
}
