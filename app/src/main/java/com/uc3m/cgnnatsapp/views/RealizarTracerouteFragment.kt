package com.uc3m.cgnnatsapp.views


import android.os.Bundle
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
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.uc3m.cgnnatsapp.R
import com.uc3m.cgnnatsapp.databinding.FragmentRealizarTracerouteBinding
import com.uc3m.cgnnatsapp.models.realizarTracerouteModel
import com.uc3m.cgnnatsapp.repository.RepositoryApi
import com.uc3m.cgnnatsapp.util.VariablesGlobales
import com.uc3m.cgnnatsapp.viewModels.ApiViewModel
import com.uc3m.cgnnatsapp.viewModels.MainViewModelFactory


class RealizarTracerouteFragment : Fragment() {

    private lateinit var binding: FragmentRealizarTracerouteBinding
    private lateinit var auth : FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    private val model = realizarTracerouteModel()


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
        binding = FragmentRealizarTracerouteBinding
                .inflate(inflater, container, false)
        val view = binding.root



        binding.BotonLogOutt.setOnClickListener{


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
                model.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion2.isChecked){
                VariablesGlobales.compañia = "Movistar"
                model.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion3.isChecked){
                VariablesGlobales.compañia = "Orange"
                model.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion4.isChecked){
                VariablesGlobales.compañia = "O2"
                model.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion5.isChecked){
                VariablesGlobales.compañia = "Jazztel"
                model.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion6.isChecked){
                VariablesGlobales.compañia = "Yoigo"
                model.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion7.isChecked){
                VariablesGlobales.compañia = "Lowi"
                model.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion8.isChecked){
                VariablesGlobales.compañia = "Adamo"
                model.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion9.isChecked){
                VariablesGlobales.compañia = "Amena"
                model.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion10.isChecked){
                VariablesGlobales.compañia = "DigiMovil"
                model.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion11.isChecked){
                VariablesGlobales.compañia = "Pepephone"
                model.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion12.isChecked){
                VariablesGlobales.compañia = "Euskatel"
                model.pedirDatosApi(viewModel,this,view)
            }else{
            if (eleccion13.isChecked){
                VariablesGlobales.compañia = "Otro"
                model.pedirDatosApi(viewModel,this,view)
            }else{
                Toast.makeText(context, "Señale la compañía que utiliza", Toast.LENGTH_LONG).show()


            } } }}}}}}}}}}}




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



