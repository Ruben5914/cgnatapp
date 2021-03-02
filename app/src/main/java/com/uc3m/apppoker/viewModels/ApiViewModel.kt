package com.uc3m.apppoker.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uc3m.apppoker.models.poker
import com.uc3m.apppoker.repository.RepositoryApi
import kotlinx.coroutines.launch
import retrofit2.Response

class ApiViewModel (private val repositoryApi: RepositoryApi): ViewModel(){

    val responseWinner: MutableLiveData<Response<poker>> = MutableLiveData()


    fun getWinner(mesa: String, manos: String){

        viewModelScope.launch {

            val response = repositoryApi.getWinner(mesa, manos)
            responseWinner.value = response
        }
    }
    /*
    fun getPlayers(){
        viewModelScope.launch {
            val response = repositoryApi.getPlayers()
            responsePlayers.value = response
        }
    }
*/
}