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

class VisualizarCartasSeleccionadasModel {

    fun pedirDatosApi(viewModel: ApiViewModel, f: Fragment, v: View) : Array<String?> {

        val  respuesta = arrayOfNulls<String>(3)
        val mesa = StringBuilder ("")
        VariablesGlobales.seleccionTotalCartasMesa.joinTo(mesa,",")

        val listaJugadores = mutableListOf<String>()
        var manoJugador = ""
        for ((n,i) in VariablesGlobales.seleccionTotalCartasJugadores.withIndex()){

            if (i != null) {
                if (n % 2 == 0) {
                    manoJugador = "$i,"
                } else {
                    manoJugador += i
                    listaJugadores.add(manoJugador)
                    manoJugador = ""
                }
            }


        }
        viewModel.getWinner(mesa.toString(), listaJugadores)
        viewModel.responseWinner.observe(f.viewLifecycleOwner, Observer { response ->

            if (response.isSuccessful) {
                val cards = response.body()?.winners?.get(0)?.cards
                val hand = response.body()?.winners?.get(0)?.hand
                val result = response.body()?.winners?.get(0)?.result
                // displayText = "The winner hand is: {ganadores.}"
                Log.d("Response --------> 1", "")
                respuesta[0] = cards.toString()
                respuesta[1] = hand.toString()
                respuesta[2] = result.toString()

                for((n,i) in respuesta[1]?.split(",")?.withIndex()!!){
                    VariablesGlobales.handGanadora[n] =
                            respuesta[1]?.split(",")?.get(n)
                }
                for((n,i) in respuesta[0]?.split(",")?.withIndex()!!){
                    VariablesGlobales.jugadorGanador[n] =
                            respuesta[0]?.split(",")?.get(n)
                }
                VariablesGlobales.resultado = result.toString()

                //guardarEnBaseDatos
                almacenarResultadoBaseDatos(respuesta[2].toString())
                v.findNavController().navigate(
                        R.id.action_visualizarCartasSeleccionadasFragment_to_Ganador)

            } else {

                Log.d("Response -------->>>>", response.code().toString())
                Log.d("Response -------->>>>", response.errorBody().toString())

            }

        })
        return respuesta
    }
    private fun almacenarResultadoBaseDatos (resultado : String){

        val resultadoTrad = VariablesGlobales.traducirResultado(resultado.toString())
        val database = Firebase.database.reference

        database.child("users")
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
                }
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