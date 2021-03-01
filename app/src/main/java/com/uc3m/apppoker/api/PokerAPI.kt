package com.uc3m.apppoker.api

import com.uc3m.apppoker.models.winners
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PokerAPI {
    @GET("v1/winner/texas_holdem")
   // suspend fun getWinner(): Response<winners>
  //  suspend fun getWinner(@Query("cc") mesa: String, @Query ("pc") manos : List<String>): Response<winners>
    suspend fun getWinner(@Query("cc") mesa: String, @Query ("pc") manos : String): Response<winners>
    //suspend fun getUsers(@Query("cc") string "AC,KD,QH,JS,7C"): Call<winners?>?
    //suspend fun getPlayers(): Response<players>

}