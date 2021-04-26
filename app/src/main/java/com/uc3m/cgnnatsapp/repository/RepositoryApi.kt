package com.uc3m.cgnnatsapp.repository

import com.uc3m.cgnnatsapp.api.RetrofitInstance
import com.uc3m.cgnnatsapp.models.ip

import retrofit2.Response


class RepositoryApi {

    suspend fun getPublicIp (): Response<ip> {

        return RetrofitInstance.IP_API.getPublicIp()
    }

}