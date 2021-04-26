package com.uc3m.cgnnatsapp.api


import com.uc3m.cgnnatsapp.models.ip

import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

interface ipAPI {
    /*
    @GET("v1/winner/texas_holdem")

    suspend fun getWinner(@Query( value = "cc", encoded = true) mesa: String, @Query (value ="pc[]", encoded = true) manos: List<String>): Response<poker>
*/
    @GET(".")
    suspend fun getPublicIp(@Query( value = "format") formato: String = "json"): Response<ip>


}



