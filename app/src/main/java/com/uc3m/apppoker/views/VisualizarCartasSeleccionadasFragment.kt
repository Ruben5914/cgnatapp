package com.uc3m.apppoker.views

import android.os.Bundle

import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.uc3m.apppoker.R
import com.uc3m.apppoker.databinding.FragmentVisualizarCartasSeleccionadasBinding

import com.uc3m.apppoker.models.Hand
import com.uc3m.apppoker.models.Usuario

import com.uc3m.apppoker.repository.RepositoryApi
import com.uc3m.apppoker.util.VariablesGlobales
import com.uc3m.apppoker.util.VariablesGlobales.Companion.seleccionTotalCartasMesa
import com.uc3m.apppoker.viewModels.ApiViewModel
import com.uc3m.apppoker.viewModels.MainViewModelFactory
import com.uc3m.apppoker.viewModels.UsuarioViewModel
import okhttp3.internal.wait


class VisualizarCartasSeleccionadasFragment : Fragment() {


    private lateinit var apiViewModel: ApiViewModel

    private lateinit var binding: FragmentVisualizarCartasSeleccionadasBinding
    private lateinit var usuarioViewModel: UsuarioViewModel
    private lateinit var auth : FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    val args: VisualizarCartasSeleccionadasFragmentArgs by navArgs()

    private var cartaSeleccionada = "ninguna"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val repositoryApi = RepositoryApi()
        val viewModelFactory = MainViewModelFactory(repositoryApi)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ApiViewModel::class.java)
        super.onCreate(savedInstanceState)
        usuarioViewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)
        auth = FirebaseAuth.getInstance()

        binding = FragmentVisualizarCartasSeleccionadasBinding.inflate(inflater, container, false)
        val view = binding.root


        var mano: String
       /* binding.botonEnviarInfoApi.setOnClickListener() {
            mano = pedirDatosApi(viewModel)
            Log.d("Response -------->Despues de la funcion llamada a API:  ", mano)
            val usuario= Usuario  (0,"UsuarioRegistroGeneral")
            usuarioViewModel.addUsuario(usuario)


        }*/
        binding.BotonLogOut.setOnClickListener(){

            auth.signOut()
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

            googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)
            googleSignInClient.signOut()

            //println(auth.currentUser?.email)
            //auth.signOut()

            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_principal)
        }



       // view.findViewById<ImageButton>(R.id.anadirCarta7).setVisibility(View.GONE)



        binding.anadirCarta1.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 1


        }
        binding.anadirCarta2.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 2


        }
        binding.anadirCarta3.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 3


        }
        binding.anadirCarta4.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 4


        }
        binding.anadirCarta5.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 5


        }
        binding.anadirCarta6.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 6


        }
        binding.anadirCarta7.setOnClickListener() {
            findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 7


        }

            cartaSeleccionada = args.CartasPicas
            var cartas = arrayOf("_0c","js","_5d","ad")
            VariablesGlobales.traducirCartas(cartas)


        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        colocarCarta()
        Log.d("Response -------->##########1?", VariablesGlobales.seleccionTotalCartasMesa[0].toString())
        Log.d("Response -------->##########2?", VariablesGlobales.seleccionTotalCartasMesa[1].toString())
        Log.d("Response -------->##########3?", VariablesGlobales.seleccionTotalCartasMesa[2].toString())
        Log.d("Response -------->##########4?", VariablesGlobales.seleccionTotalCartasMesa[3].toString())
        Log.d("Response -------->##########5?", VariablesGlobales.seleccionTotalCartasMesa[4].toString())
    }


    override fun onPause() {
        super.onPause()
        var cartaSeleccionada = "Pausado"
        Log.d("Response -------->Fragmento devuelve:  ", cartaSeleccionada)
    }

    private fun colocarCarta(){


        if (VariablesGlobales.posicionCarta != 0){

            VariablesGlobales.seleccionTotalCartasMesa[VariablesGlobales.posicionCarta-1] = cartaSeleccionada
            var n = 1
            for (i in VariablesGlobales.seleccionTotalCartasMesa){

                if (i != null){

                    view?.findViewById<ImageButton>(getResources().getIdentifier("anadirCarta"+n.toString(),"id", context?.getPackageName()))?.setBackgroundResource(getResources().getIdentifier(i,"drawable", context?.getPackageName()))
                     }
                n++
            }

            VariablesGlobales.posicionCarta = 0

        }

    }




    fun pedirDatosApi(viewModel: ApiViewModel) :String {
       // var datos = binding.introducirCartas.text.toString()

        var mano: String
         mano = "nulo"
        /*


                var mesa: List<String> = datos.toString().split('/')
                viewModel.getWinner(mesa.get(0), mesa.get(1))


                viewModel.responseWinner.observe(viewLifecycleOwner, Observer { response ->

                    if (response.isSuccessful) {
                        val ganadores = response.body()?.winners?.get(0)?.result
                        // displayText = "The winner hand is: {ganadores.}"
                        Log.d("Response --------> 1", "")

                        mano = ganadores.toString()
                        guardarEnBaseDatos(mano)
                        mostrarManosBaseDatos()
                        Log.d("Response -------->La API devuelve?", ganadores.toString())
                    } else {

                        Log.d("Response -------->>>>", response.code().toString())
                        Log.d("Response -------->>>>", response.errorBody().toString())


                    }

                })


        */
        return mano


    }

     fun onclick(V: View){
         var adapter = "yes"
         Log.d("Response --------oooooooo>>>>", adapter)
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

