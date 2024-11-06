package com.phuonnngminh.currencyconverter.main

import com.phuonnngminh.currencyconverter.data.models.CurrencyResponse
import com.phuonnngminh.currencyconverter.util.Resource

interface MainRepository {

    suspend fun getRates(symbols: String): Resource<CurrencyResponse>
}