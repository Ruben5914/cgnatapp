package com.uc3m.apppoker.views

import android.os.Bundle

import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.uc3m.apppoker.R
import com.uc3m.apppoker.databinding.FragmentVisualizarCartasSeleccionadasBinding

import com.uc3m.apppoker.models.Hand
import com.uc3m.apppoker.models.Usuario

import com.uc3m.apppoker.repository.RepositoryApi
import com.uc3m.apppoker.viewModels.ApiViewModel
import com.uc3m.apppoker.viewModels.MainViewModelFactory
import com.uc3m.apppoker.viewModels.UsuarioViewModel
import okhttp3.internal.wait


class visualizarCartasSeleccionadasFragment : Fragment() {


    private lateinit var apiViewModel: ApiViewModel

    private lateinit var binding: FragmentVisualizarCartasSeleccionadasBinding
    private lateinit var usuarioViewModel: UsuarioViewModel





    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val repositoryApi = RepositoryApi()
        val viewModelFactory = MainViewModelFactory(repositoryApi)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ApiViewModel::class.java)
        super.onCreate(savedInstanceState)
        usuarioViewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)

        binding = FragmentVisualizarCartasSeleccionadasBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.anadirCarta1Mesa.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)

        }
        var mano: String
        binding.botonEnviarInfoApi.setOnClickListener() {
            mano = pedirDatosApi(viewModel)
            Log.d("Response -------->Despues de la funcion llamada a API:  ", mano)
            val usuario= Usuario  (0,"UsuarioRegistroGeneral")
            usuarioViewModel.addUsuario(usuario)
            guardarEnBaseDatos(mano)

        }
        mostrarManosBaseDatos()





        return view
    }

    fun pedirDatosApi(viewModel: ApiViewModel) :String {
        var datos = binding.introducirCartas.text.toString()

        var mano: String
        mano = "nulo"



            var mesa: List<String> = datos.toString().split('/')
            viewModel.getWinner(mesa.get(0), mesa.get(1))


            viewModel.responseWinner.observe(viewLifecycleOwner, Observer { response ->

                if (response.isSuccessful) {
                    val ganadores = response.body()?.winners?.get(0)?.result
                    // displayText = "The winner hand is: {ganadores.}"
                    Log.d("Response --------> 1", "")

                    mano = ganadores.toString()
                    Log.d("Response -------->La API devuelve?", ganadores.toString())
                } else {

                    Log.d("Response -------->>>>", response.code().toString())
                    Log.d("Response -------->>>>", response.errorBody().toString())


                }

            })



            return mano


    }

    private fun mostrarManosBaseDatos() {
       //Log.d("Response -------->>>>", usuarioViewModel.findUsuario(0))

        val adapter = ListAdapter()
        val recyclerView = binding.mostrarResultadoApi
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        usuarioViewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)
        usuarioViewModel.readAllHands.observe(viewLifecycleOwner,{
            hands -> adapter.setData( hands)
        })





    }
    private fun guardarEnBaseDatos (hand:String){
        Log.d("Response --------> 2", "")
        val hand = Hand(0, 1, hand)
        usuarioViewModel.addHandToUser(hand)
    }

}




