package com.uc3m.apppoker.models

import android.content.Context
import android.util.Log
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.uc3m.apppoker.R
import com.uc3m.apppoker.util.VariablesGlobales
import com.uc3m.apppoker.viewModels.ApiViewModel
import java.lang.StringBuilder
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.uc3m.apppoker.views.VisualizarCartasSeleccionadasFragment
import com.wandroid.traceroute.TraceRoute

class VisualizarCartasSeleccionadasModel {

    fun pedirDatosApi(viewModel: ApiViewModel, f: Fragment, v: View)  {


        viewModel.getPublicIp()
        viewModel.responseWinner.observe(f.viewLifecycleOwner, Observer { response ->

            if (response.isSuccessful) {

                val ip = response.body()?.ip.toString()

                Log.d("Response -------->>>>", ip)

                val botonStart: Button = v.findViewById(R.id.botonSubmit)
                val infoInicial: TextView = v.findViewById(R.id.textoInicial)
                var animacion : Animation = AlphaAnimation(1.0f,0.0f)
                animacion.duration = 5000
                botonStart.startAnimation(animacion)
                botonStart.visibility = View.GONE
                infoInicial.startAnimation(animacion)
                infoInicial.visibility = View.GONE

                TraceRoute.setCallback {
                    success {
                        Log.d("tagg", VariablesGlobales.resultadoTraceroute)
                       val viewVisualizarResultado = VisualizarCartasSeleccionadasFragment ()
                        viewVisualizarResultado.mostrarTraceroute(v)

                        almacenarResultadoBaseDatos(VariablesGlobales.resultadoTraceroute)

                    }
                    //update { text -> Log.d("tag", text) }
                    update {text -> VariablesGlobales.resultadoTraceroute =  VariablesGlobales.resultadoTraceroute + text}
                    failed { code, reason -> Log.d("tag", """\ntraceroute failed.code:$code, reason:$reason""") }
                }
                TraceRoute.traceRoute("www.google.com", true)

            } else {

                Log.d("Response -------->>>>", response.code().toString())
                Log.d("Response -------->>>>", response.errorBody().toString())

            }

        })

    }
    private fun almacenarResultadoBaseDatos (resultado : String){

        val compañia = VariablesGlobales.compañia
        val database = Firebase.database.reference
        database.child("users")
            .child(FirebaseAuth.getInstance().currentUser.uid)
            .child("Datos recopilados")
            .child("Compañía").setValue(compañia)
        database.child("users")
            .child(FirebaseAuth.getInstance().currentUser.uid)
            .child("Datos recopilados")
            .child("traceroute").setValue(resultado)
        database.child("users")
            .child(FirebaseAuth.getInstance().currentUser.uid)
            .child("Usuario")
            .setValue(FirebaseAuth.getInstance().currentUser.displayName)

    }

    fun comprobarUsuarioEnBaseDatos (){

        val database = Firebase.database.reference
        database.child("users")
                .child(FirebaseAuth.getInstance().currentUser.uid)
                .child("estadisticas").get().addOnSuccessListener {

                    if (it.value == null){

                        val mano = Mano ()
                        database.child("users")
                                .child(FirebaseAuth.getInstance().currentUser.uid)
                                .child("estadisticas").setValue(mano)
                    }
                }.addOnFailureListener{
                    Log.e("firebase", "Error getting data", it)
                }



    }



}