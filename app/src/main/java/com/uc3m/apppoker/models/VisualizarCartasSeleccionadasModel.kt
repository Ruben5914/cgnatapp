package com.uc3m.apppoker.models

import android.content.Context
import android.util.Log
import android.view.View
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
import com.wandroid.traceroute.TraceRoute

class VisualizarCartasSeleccionadasModel {

    fun pedirDatosApi(viewModel: ApiViewModel, f: Fragment, v: View)  {


        viewModel.getPublicIp()
        viewModel.responseWinner.observe(f.viewLifecycleOwner, Observer { response ->

            if (response.isSuccessful) {

                val ip = response.body()?.ip.toString()

                Log.d("Response -------->>>>", ip)

                TraceRoute.setCallback {
                    success {
                        Log.d("tagg", VariablesGlobales.resultadoTraceroute)
                        //mostrarTraceroute()
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
       /* database.child("users")
                .child(FirebaseAuth.getInstance().currentUser.uid)
                .child("estadisticas")
                .child(resultadoTrad).get().addOnSuccessListener {

                    var contador : Long = it.value.toString().toLong()
                    //EncryptModel.decryptData(iv,it.value as ByteArray) as Long
                    contador = contador + 1
                    database.child("users")
                            .child(FirebaseAuth.getInstance().currentUser.uid)
                            .child("estadisticas")
                            .child(resultadoTrad).setValue(contador)

                }.addOnFailureListener{
                    Log.e("firebase", "Error getting data", it)
                }*/
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

    fun comprobarCartas(mesa: Array<String?>, jugadores: Array<String?>, context: Context): Boolean{

        var contieneNull1 = false
        var contieneNull2 = false
        var finalPareja = false
        for( i in mesa){
            if (i == null){
                Toast.makeText(context, "Faltan cartas en la mesa", Toast.LENGTH_SHORT).show()
                return false
            }
        }
        var todosNull = true
        for( i in jugadores){
            if (i != null){

                todosNull = false
            }
        }
        if (todosNull){
            Toast.makeText(context, "Añadir al menos un jugador", Toast.LENGTH_SHORT).show()
            return false
        }
        for ((n,i) in jugadores.withIndex()){
            if (n % 2 != 0){
                finalPareja = true
            }
            if(!finalPareja){
                contieneNull1 = ( i == null)
            }else {
                contieneNull2 = (i == null)
            }
            finalPareja = false


            if (n % 2 != 0){
                if (contieneNull1 != contieneNull2){
                    Toast.makeText(context, "Jugador mal introducido", Toast.LENGTH_SHORT)
                            .show()
                    return false
                }
            }

        }


        val cartas = arrayOfNulls<String>(mesa.size + jugadores.size)
        for ((n,i) in mesa.withIndex()){
            cartas[n] = i
        }
        var k = mesa.size
        for ((n,i) in jugadores.withIndex()){
            k += n
            cartas[k] = i
            k -= n
        }

        for((n, i) in cartas.withIndex()){
            for ((k, j) in cartas.withIndex()){
                if (n != k ){
                    if (i == j && i != null ){
                        Toast.makeText(context,
                                "No puede haber cartas repetidas", Toast.LENGTH_SHORT).show()
                        return false
                    }
                }

            }
        }


        return true
    }
}