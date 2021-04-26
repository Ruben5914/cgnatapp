package com.uc3m.apppoker.views


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
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
    private val args: VisualizarCartasSeleccionadasFragmentArgs by navArgs()
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



        binding.botonSubmit.setOnClickListener{

          /*  val datosCorrectos = context?.let { it1 ->
                modelVisualizarCartasSeleccionadas.comprobarCartas(VariablesGlobales
                        .seleccionTotalCartasMesa,VariablesGlobales.seleccionTotalCartasJugadores, it1)
            }

            if (datosCorrectos == true){
                VariablesGlobales.traducirCartas(VariablesGlobales.seleccionTotalCartasJugadores)
                VariablesGlobales.traducirCartas(VariablesGlobales.seleccionTotalCartasMesa)
*/

                modelVisualizarCartasSeleccionadas.pedirDatosApi(viewModel,this,view)

           // }
        }

           cartaSeleccionada = args.CartasPicas

        return view
    }
    fun mostrarTraceroute(v : View){

        val presentardatos : TextView = v.findViewById(R.id.textoresultado)
        val mostrardatos: TextView = v.findViewById(R.id.textomostrarresultado)


        mostrardatos.text = VariablesGlobales.resultadoTraceroute

        var animacion : Animation = AlphaAnimation(0.0f,1.0f)
        animacion.duration = 5000
        presentardatos.visibility = View.VISIBLE
        presentardatos.startAnimation(animacion)
        mostrardatos.visibility = View.VISIBLE
        mostrardatos.startAnimation(animacion)


    }






}



