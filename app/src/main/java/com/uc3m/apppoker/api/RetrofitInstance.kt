package com.uc3m.apppoker.api

import com.uc3m.apppoker.util.Constants.Companion.POKER_URL
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {



    //gracias al ssl pinner evitamos ataques de man in the middle
    val certificatePinner = CertificatePinner.Builder()
            .add("pokerapi.dev","sha256/u8pwQx09TKSYlyrUpr4LK5f61Oaq8cvAkVn5O02oHik=").build()

    val okHttpClient = OkHttpClient.Builder().certificatePinner(certificatePinner).build()

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(POKER_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient)
                .build()
    }

    val pokerAPI: PokerAPI by lazy {
        retrofit.create(PokerAPI::class.java)
    }
}

