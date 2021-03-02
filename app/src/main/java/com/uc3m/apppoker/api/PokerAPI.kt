package com.uc3m.apppoker.api


import com.uc3m.apppoker.models.poker
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

interface PokerAPI {
    @GET("v1/winner/texas_holdem")

    suspend fun getWinner(@Query( value = "cc", encoded = true) mesa: String, @Query (value ="pc[]", encoded = true) manos: String): Response<poker>


}