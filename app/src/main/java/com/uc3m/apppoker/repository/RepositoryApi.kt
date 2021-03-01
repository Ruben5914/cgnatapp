package com.uc3m.apppoker.repository

import com.uc3m.apppoker.api.RetrofitInstance
import com.uc3m.apppoker.models.winners
import retrofit2.Response


class RepositoryApi {
    suspend fun getWinner (mesa: String, manos: String): Response<winners> {

        return RetrofitInstance.pokerAPI.getWinner(mesa, manos)
    }
    /*suspend fun getPlayers (): Response<players> {
        return RetrofitInstance.pokerAPI.getPlayers()
    }
*/
}