package com.uc3m.apppoker.api

import com.uc3m.apppoker.util.Constants.Companion.POKER_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(POKER_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val pokerAPI: PokerAPI by lazy {
        retrofit.create(PokerAPI::class.java)
    }
}

