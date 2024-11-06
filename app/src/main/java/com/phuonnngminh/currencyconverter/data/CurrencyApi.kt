package com.phuonnngminh.currencyconverter.data

import com.phuonnngminh.currencyconverter.data.models.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyApi {
    companion object {
        const val BASE_URL: String = "https://api.exchangeratesapi.io/"
        const val API_KEY: String = "ec320bf60f1985e1911b788ce3059eae"
    }

    @GET("v1/latest")
    suspend fun getRates(
        @Query("symbols") symbols: String,
        @Query("access_key") apiKey: String = API_KEY
    ): Response<CurrencyResponse>
}