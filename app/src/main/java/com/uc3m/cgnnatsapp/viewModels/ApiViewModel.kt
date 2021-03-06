package com.uc3m.cgnnatsapp.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc3m.cgnnatsapp.models.ip

import com.uc3m.cgnnatsapp.repository.RepositoryApi
import kotlinx.coroutines.launch
import retrofit2.Response

class ApiViewModel (private val repositoryApi: RepositoryApi): ViewModel(){


   val responseWinner: MutableLiveData<Response<ip>> = MutableLiveData()



    fun getPublicIp (){
        viewModelScope.launch {

            val response = repositoryApi.getPublicIp()
            responseWinner.value = response
        }
    }

}