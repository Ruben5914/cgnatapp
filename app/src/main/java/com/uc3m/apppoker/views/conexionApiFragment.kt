package com.uc3m.apppoker.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uc3m.apppoker.repository.RepositoryApi
import com.uc3m.apppoker.viewModels.ApiViewModel
import com.uc3m.apppoker.viewModels.MainViewModelFactory


class conexionApiFragment : Fragment() {

    private lateinit var apiViewModel: ApiViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repositoryApi = RepositoryApi()
        val viewModelFactory = MainViewModelFactory(repositoryApi)
        val viewModel = ViewModelProvider(this,viewModelFactory).get(ApiViewModel::class.java)

        //var mesa = "AC,KD,QH,JS,7C"
       // var manos = "10S,8C"
      //  var manos: List<String> = listOf("10S,8C","3S,2C","QS,JH")

        var mesa =  "AC,KD,QH,JS,7C"

        var manos = "10S,8C"
       // viewModel.getWinner(mesa, manos)

        viewModel.responseWinner.observe(this, Observer { response ->

            if(response.isSuccessful){
                val ganadores = response.body()?.winners?.get(0)?.result
                // displayText = "The winner hand is: {ganadores.}"
                Log.d("Response -------->", ganadores.toString())
            }else{

                Log.d("Response -------->>>>", response.code().toString())
                Log.d("Response -------->>>>", response.errorBody().toString())



            }
        }
        )


    }


}