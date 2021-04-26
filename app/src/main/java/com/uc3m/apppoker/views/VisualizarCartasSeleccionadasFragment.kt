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

        //modelVisualizarCartasSeleccionadas.comprobarUsuarioEnBaseDatos()


        binding.BotonLogOutt.setOnClickListener{

            //Tras cerrar sesion se ponen las variables globales por defecto

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

            val eleccion1 : RadioButton = view.findViewById(R.id.Vodafone)
            val eleccion2 : RadioButton = view.findViewById(R.id.Movistar)
            val eleccion3 : RadioButton = view.findViewById(R.id.Orange)
            val eleccion4 : RadioButton = view.findViewById(R.id.O2)
            val eleccion5 : RadioButton = view.findViewById(R.id.Jazztel)
            val eleccion6 : RadioButton = view.findViewById(R.id.Yoigo)
            val eleccion7 : RadioButton = view.findViewById(R.id.Lowi)
            val eleccion8 : RadioButton = view.findViewById(R.id.Adamo)
            val eleccion9 : RadioButton = view.findViewById(R.id.Amena)
            val eleccion10 : RadioButton = view.findViewById(R.id.DigiMobil)
            val eleccion11 : RadioButton = view.findViewById(R.id.Pepephone)
            val eleccion12 : RadioButton = view.findViewById(R.id.Euskatel)
            val eleccion13 : RadioButton = view.findViewById(R.id.Otro)



            if (eleccion1.isChecked){
                VariablesGlobales.compañia = "Vodafone"
                modelVisualizarCartasSeleccionadas.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion2.isChecked){
                VariablesGlobales.compañia = "Movistar"
                modelVisualizarCartasSeleccionadas.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion3.isChecked){
                VariablesGlobales.compañia = "Orange"
                modelVisualizarCartasSeleccionadas.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion4.isChecked){
                VariablesGlobales.compañia = "O2"
                modelVisualizarCartasSeleccionadas.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion5.isChecked){
                VariablesGlobales.compañia = "Jazztel"
                modelVisualizarCartasSeleccionadas.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion6.isChecked){
                VariablesGlobales.compañia = "Yoigo"
                modelVisualizarCartasSeleccionadas.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion7.isChecked){
                VariablesGlobales.compañia = "Lowi"
                modelVisualizarCartasSeleccionadas.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion8.isChecked){
                VariablesGlobales.compañia = "Adamo"
                modelVisualizarCartasSeleccionadas.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion9.isChecked){
                VariablesGlobales.compañia = "Amena"
                modelVisualizarCartasSeleccionadas.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion10.isChecked){
                VariablesGlobales.compañia = "DigiMovil"
                modelVisualizarCartasSeleccionadas.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion11.isChecked){
                VariablesGlobales.compañia = "Pepephone"
                modelVisualizarCartasSeleccionadas.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion12.isChecked){
                VariablesGlobales.compañia = "Euskatel"
                modelVisualizarCartasSeleccionadas.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion13.isChecked){
                VariablesGlobales.compañia = "Otro"
                modelVisualizarCartasSeleccionadas.pedirDatosApi(viewModel,this,view)
            }else{
                Toast.makeText(context, "Señale la compañía que utiliza", Toast.LENGTH_LONG).show()


            } } }}}}}}}}}}}



           // }
        }



        return view
    }
    fun mostrarTraceroute(v : View){

        val presentardatos : TextView = v.findViewById(R.id.textoresultado)
        val mostrardatosscroll: ScrollView = v.findViewById(R.id.textomostrarresultadoscroll)
        val mostrardatos: TextView = v.findViewById(R.id.textomostrarresultado)


        mostrardatos.text = VariablesGlobales.resultadoTraceroute

        var animacion : Animation = AlphaAnimation(0.0f,1.0f)
        animacion.duration = 6000
        presentardatos.visibility = View.VISIBLE
        presentardatos.startAnimation(animacion)
        mostrardatosscroll.visibility = View.VISIBLE
        mostrardatosscroll.startAnimation(animacion)


    }






}



