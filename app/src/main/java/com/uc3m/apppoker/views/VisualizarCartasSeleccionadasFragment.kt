package com.uc3m.apppoker.views


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.addCallback
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.uc3m.apppoker.R
import com.uc3m.apppoker.databinding.FragmentVisualizarCartasSeleccionadasBinding
import com.uc3m.apppoker.models.VisualizarCartasSeleccionadasModel
import com.uc3m.apppoker.repository.RepositoryApi
import com.uc3m.apppoker.util.VariablesGlobales
import com.uc3m.apppoker.viewModels.ApiViewModel
import com.uc3m.apppoker.viewModels.MainViewModelFactory
import com.wandroid.traceroute.TraceRoute


class VisualizarCartasSeleccionadasFragment : Fragment() {

    private lateinit var binding: FragmentVisualizarCartasSeleccionadasBinding
    private lateinit var auth : FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
   // private val args: VisualizarCartasSeleccionadasFragmentArgs by navArgs()
    private val modelVisualizarCartasSeleccionadas = VisualizarCartasSeleccionadasModel()

    private var cartaSeleccionada = "ninguna"



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Evitamos que el usuario pueda navegar hacia atras
        }

        val repositoryApi = RepositoryApi()
        val viewModelFactory = MainViewModelFactory(repositoryApi)
        val viewModel = ViewModelProvider(this, viewModelFactory)
                .get(ApiViewModel::class.java)
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        binding = FragmentVisualizarCartasSeleccionadasBinding
                .inflate(inflater, container, false)
        val view = binding.root

        modelVisualizarCartasSeleccionadas.comprobarUsuarioEnBaseDatos()
        //val traceresult = TraceRoute.traceRoute("www.google.com")
        //Log.d("eee",traceresult?.message.toString())



        binding.BotonLogOutt.setOnClickListener{

            //Tras cerrar sesion se ponen las variables globales por defecto
            VariablesGlobales.posicionCarta = 0
            VariablesGlobales.seleccionTotalCartasMesa = arrayOfNulls(5)
            VariablesGlobales.jugadorGanador = arrayOfNulls(2)
            VariablesGlobales.handGanadora = arrayOfNulls(5)
            VariablesGlobales.seleccionTotalCartasJugadores = arrayOfNulls(12)
            VariablesGlobales.resultado = ""
            auth.signOut()
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

            googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)
            googleSignInClient.signOut()


            findNavController().navigate(
                    R.id.action_visualizarCartasSeleccionadasFragment_to_principal)
        }


        binding.anadirCarta1.setOnClickListener {
            findNavController().navigate(
                    R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 1


        }
        binding.anadirCarta2.setOnClickListener {
            findNavController().navigate(
                    R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 2


        }
        binding.anadirCarta3.setOnClickListener {
            findNavController().navigate(
                    R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 3


        }
        binding.anadirCarta4.setOnClickListener {
            findNavController().navigate(
                    R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 4


        }
        binding.anadirCarta5.setOnClickListener {
            findNavController().navigate(
                    R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 5


        }
        binding.anadirCarta6.setOnClickListener {
            findNavController().navigate(
                    R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 6


        }
        binding.anadirCarta7.setOnClickListener {
            findNavController().navigate(
                    R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 7


        }

        binding.anadirCarta8.setOnClickListener {
            findNavController().navigate(
                    R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 8


        }
        binding.anadirCarta9.setOnClickListener {
            findNavController().navigate(
                    R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 9


        }
        binding.anadirCarta10.setOnClickListener {
            findNavController().navigate(
                    R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 10


        }
        binding.anadirCarta11.setOnClickListener {
            findNavController().navigate(
                    R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 11


        }
        binding.anadirCarta12.setOnClickListener {
            findNavController().navigate(
                    R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 12


        }
        binding.anadirCarta13.setOnClickListener {
            findNavController().navigate(
                    R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 13


        }
        binding.anadirCarta14.setOnClickListener {
            findNavController().navigate(
                    R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 14


        }
        binding.anadirCarta15.setOnClickListener {
            findNavController().navigate(
                    R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 15


        }
        binding.anadirCarta16.setOnClickListener {
            findNavController().navigate(
                    R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 16


        }
        binding.anadirCarta17.setOnClickListener {
            findNavController().navigate(R
                    .id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
            VariablesGlobales.posicionCarta = 17


        }
        binding.eliminar1.setOnClickListener{
            VariablesGlobales.seleccionTotalCartasJugadores[0] = null
            VariablesGlobales.seleccionTotalCartasJugadores[1] = null
            view.findViewById<ImageButton>(R.id.anadirCarta6)
                    .setBackgroundResource(R.drawable.addcard)
            view.findViewById<ImageButton>(R.id.anadirCarta7)
                    .setBackgroundResource(R.drawable.addcard)
        }
        binding.eliminar2.setOnClickListener{
            VariablesGlobales.seleccionTotalCartasJugadores[2] = null
            VariablesGlobales.seleccionTotalCartasJugadores[3] = null
            view.findViewById<ImageButton>(R.id.anadirCarta8)
                    .setBackgroundResource(R.drawable.addcard)
            view.findViewById<ImageButton>(R.id.anadirCarta9)
                    .setBackgroundResource(R.drawable.addcard)
        }
        binding.eliminar3.setOnClickListener{
            VariablesGlobales.seleccionTotalCartasJugadores[4] = null
            VariablesGlobales.seleccionTotalCartasJugadores[5] = null
            view.findViewById<ImageButton>(R.id.anadirCarta10)
                    .setBackgroundResource(R.drawable.addcard)
            view.findViewById<ImageButton>(R.id.anadirCarta11)
                    .setBackgroundResource(R.drawable.addcard)
        }
        binding.eliminar4.setOnClickListener{
            VariablesGlobales.seleccionTotalCartasJugadores[6] = null
            VariablesGlobales.seleccionTotalCartasJugadores[7] = null
            view.findViewById<ImageButton>(R.id.anadirCarta12)
                    .setBackgroundResource(R.drawable.addcard)
            view.findViewById<ImageButton>(R.id.anadirCarta13)
                    .setBackgroundResource(R.drawable.addcard)
        }
        binding.eliminar5.setOnClickListener{
            VariablesGlobales.seleccionTotalCartasJugadores[8] = null
            VariablesGlobales.seleccionTotalCartasJugadores[9] = null
            view.findViewById<ImageButton>(R.id.anadirCarta14)
                    .setBackgroundResource(R.drawable.addcard)
            view.findViewById<ImageButton>(R.id.anadirCarta15)
                    .setBackgroundResource(R.drawable.addcard)
        }

        binding.botonestadisticas.setOnClickListener{
            findNavController()
                    .navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_estadisticas)
        }
        binding.botonSubmit.setOnClickListener{

            val datosCorrectos = context?.let { it1 ->
                modelVisualizarCartasSeleccionadas.comprobarCartas(VariablesGlobales
                        .seleccionTotalCartasMesa,VariablesGlobales.seleccionTotalCartasJugadores, it1)
            }

            if (datosCorrectos == true){
                VariablesGlobales.traducirCartas(VariablesGlobales.seleccionTotalCartasJugadores)
                VariablesGlobales.traducirCartas(VariablesGlobales.seleccionTotalCartasMesa)


                modelVisualizarCartasSeleccionadas.pedirDatosApi(viewModel,this,view)[2]

            }
        }

           // cartaSeleccionada = args.CartasPicas
        cartaSeleccionada = "AS"
        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        colocarCarta()
    }


    private fun colocarCarta() {

        if (VariablesGlobales.posicionCarta != 0) {
            if (VariablesGlobales.posicionCarta != 100) {


                if (VariablesGlobales.posicionCarta < 6) {

                    VariablesGlobales
                            .seleccionTotalCartasMesa[VariablesGlobales.posicionCarta - 1] =
                        cartaSeleccionada

                } else {

                    VariablesGlobales
                            .seleccionTotalCartasJugadores[VariablesGlobales.posicionCarta - 6] =
                        cartaSeleccionada

                }
            }
                var n = 1
                for (i in VariablesGlobales.seleccionTotalCartasMesa) {

                    if (i != null) {

                        view?.findViewById<ImageButton>(
                            getResources().getIdentifier(
                                    "anadirCarta$n",
                                "id",
                                context?.packageName
                            )
                        )?.setBackgroundResource(
                            getResources().getIdentifier(
                                i,
                                "drawable",
                                context?.packageName
                            )
                        )
                    }
                    n++
                }
                var o = 6

                for (i in VariablesGlobales.seleccionTotalCartasJugadores) {

                    if (i != null) {


                        view?.findViewById<ImageButton>(
                            resources.getIdentifier(
                                    "anadirCarta$o",
                                "id",
                                context?.packageName
                            )
                        )?.setBackgroundResource(
                            resources.getIdentifier(
                                i,
                                "drawable",
                                context?.packageName
                            )
                        )

                    }
                    o++
                }
                VariablesGlobales.posicionCarta = 0
        }
    }
}



