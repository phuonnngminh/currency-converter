package com.phuonnngminh.currencyconverter.main

import com.phuonnngminh.currencyconverter.data.CurrencyApi
import com.phuonnngminh.currencyconverter.data.models.CurrencyResponse
import com.phuonnngminh.currencyconverter.util.Resource
import javax.inject.Inject

class DefaultMainRepository @Inject constructor(
    private val api: CurrencyApi
) : MainRepository {

    override suspend fun getRates(symbols: String): Resource<CurrencyResponse> {
        return try {
            val response = api.getRates(symbols)
            val result = response.body()
            if(response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch(e: Exception) {
            Resource.Error(e.message ?: "An error occured")
        }
    }
}