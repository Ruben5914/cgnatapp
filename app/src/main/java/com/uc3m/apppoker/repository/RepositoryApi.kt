package com.uc3m.apppoker.repository

import com.uc3m.apppoker.api.RetrofitInstance
import com.uc3m.apppoker.models.poker
import retrofit2.Response


class RepositoryApi {
    suspend fun getWinner (mesa: String, manos: String): Response<poker> {

        return RetrofitInstance.pokerAPI.getWinner(mesa, manos)
    }
    /*suspend fun getPlayers (): Response<players> {
        return RetrofitInstance.pokerAPI.getPlayers()
    }
*/
}