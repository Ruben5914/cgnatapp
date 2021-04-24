package com.uc3m.apppoker.repository

import com.uc3m.apppoker.api.RetrofitInstance
import com.uc3m.apppoker.models.ip

import retrofit2.Response


class RepositoryApi {

    suspend fun getPublicIp (): Response<ip> {

        return RetrofitInstance.IP_API.getPublicIp()
    }

}