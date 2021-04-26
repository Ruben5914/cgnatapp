package com.uc3m.cgnnatsapp.models

import android.util.Log
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.*
import androidx.fragment.app.Fragment
import com.uc3m.cgnnatsapp.R
import com.uc3m.cgnnatsapp.util.VariablesGlobales
import com.uc3m.cgnnatsapp.viewModels.ApiViewModel
import androidx.lifecycle.Observer
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.uc3m.cgnnatsapp.views.RealizarTracerouteFragment
import com.wandroid.traceroute.TraceRoute

class realizarTracerouteModel {

    fun pedirDatosApi(viewModel: ApiViewModel, f: Fragment, v: View)  {


        viewModel.getPublicIp()
        viewModel.responseWinner.observe(f.viewLifecycleOwner, Observer { response ->

            if (response.isSuccessful) {

                val ip = response.body()?.ip.toString()

                Log.d("Response -------->>>>", ip)

                val botonStart: Button = v.findViewById(R.id.botonSubmit)
                val botonlogout: Button = v.findViewById(R.id.BotonLogOutt)
                val infoInicial: TextView = v.findViewById(R.id.textoInicial)
                var animacion : Animation = AlphaAnimation(1.0f,0.0f)
                var animacion2 : Animation = AlphaAnimation(0.0f,1.0f)
                val textocargando: TextView = v.findViewById(R.id.textocargando)
                val seleccion: ScrollView = v.findViewById(R.id.scrollradio)
                val textoresultado: TextView = v.findViewById(R.id.textoresultado)
                animacion2.duration = 6000
                animacion.duration = 3000
                botonStart.startAnimation(animacion)
                botonStart.visibility = View.GONE
                infoInicial.startAnimation(animacion)
                infoInicial.visibility = View.GONE
                botonlogout.startAnimation(animacion)
                botonlogout.visibility = View.GONE
                seleccion.startAnimation(animacion)
                seleccion.visibility = View.GONE

                val lottie: com.airbnb.lottie.LottieAnimationView = v.findViewById(R.id.animacionLottie)
                lottie.visibility = View.VISIBLE
                lottie.startAnimation(animacion2)
                textocargando.visibility = View.VISIBLE
                textocargando.startAnimation(animacion2)


                TraceRoute.setCallback {
                    success {
                        textocargando.visibility = View.VISIBLE
                        textocargando.startAnimation(animacion2)
                        lottie.startAnimation(animacion)
                        lottie.visibility = View.GONE
                        textocargando.startAnimation(animacion)
                        textocargando.visibility = View.GONE
                        botonlogout.visibility =View.VISIBLE
                        botonlogout.startAnimation(animacion2)
                        Log.d("tagg", VariablesGlobales.resultadoTraceroute)
                       val viewVisualizarResultado = RealizarTracerouteFragment ()
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
/*
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



    }*/



}