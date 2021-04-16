package com.uc3m.apppoker.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.uc3m.apppoker.R
import com.uc3m.apppoker.databinding.FragmentEstadisticasBinding
import com.uc3m.apppoker.util.VariablesGlobales
import com.uc3m.apppoker.viewModels.EncryptModel
import okhttp3.internal.wait


class Estadisticas : Fragment() {
    private lateinit var binding: FragmentEstadisticasBinding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

         requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Evitamos que el usuario pueda navegar hacia atras
        }
        binding = FragmentEstadisticasBinding.inflate(inflater, container, false)
        val view = binding.root

        VariablesGlobales.posicionCarta = 100
        val database = Firebase.database.reference


        database.child("users")
                .child(FirebaseAuth.getInstance().currentUser.uid)
                .child("estadisticas")
                .child("cartaAlta").get().addOnSuccessListener {


            var label : TextView= view.findViewById(R.id.respuesta1)
            label.text = it.value.toString()
            label.textSize = 22F
            var animacion : Animation = AnimationUtils.loadAnimation(context, R.anim.animcrecer)
            label.startAnimation(animacion)

            database.child("users")
                    .child(FirebaseAuth.getInstance().currentUser.uid)
                    .child("estadisticas")
                    .child("pareja").get().addOnSuccessListener {


                 label = view.findViewById(R.id.respuesta2)
                label.text = it.value.toString()
                label.textSize = 22F
                var animacion : Animation = AnimationUtils.loadAnimation(context, R.anim.animcrecer)
                label.startAnimation(animacion)

                database.child("users")
                        .child(FirebaseAuth.getInstance().currentUser.uid)
                        .child("estadisticas")
                        .child("doblePareja").get().addOnSuccessListener {


                     label = view.findViewById(R.id.respuesta3)
                    label.text = it.value.toString()
                    label.textSize = 22F
                    var animacion : Animation = AnimationUtils.loadAnimation(
                            context, R.anim.animcrecer)
                    label.startAnimation(animacion)


                    database.child("users")
                            .child(FirebaseAuth.getInstance().currentUser.uid)
                            .child("estadisticas")
                            .child("trio").get().addOnSuccessListener {


                         label = view.findViewById(R.id.respuesta4)
                        label.text = it.value.toString()
                        label.textSize = 22F
                        var animacion : Animation = AnimationUtils.loadAnimation(
                                context, R.anim.animcrecer)
                        label.startAnimation(animacion)


                        database.child("users")
                                .child(FirebaseAuth.getInstance().currentUser.uid)
                                .child("estadisticas")
                                .child("escalera").get().addOnSuccessListener {


                             label = view.findViewById(R.id.respuesta5)
                            label.text = it.value.toString()
                            label.textSize = 22F
                            var animacion : Animation = AnimationUtils.loadAnimation(
                                    context, R.anim.animcrecer)
                            label.startAnimation(animacion)


                            database.child("users")
                                    .child(FirebaseAuth.getInstance().currentUser.uid)
                                    .child("estadisticas")
                                    .child("color").get().addOnSuccessListener {


                                 label = view.findViewById(R.id.respuesta6)
                                label.text = it.value.toString()
                                label.textSize = 22F
                                var animacion : Animation = AnimationUtils.loadAnimation(
                                        context, R.anim.animcrecer)
                                label.startAnimation(animacion)

                                database.child("users")
                                        .child(FirebaseAuth.getInstance().currentUser.uid)
                                        .child("estadisticas")
                                        .child("full").get().addOnSuccessListener {


                                     label = view.findViewById(R.id.respuesta7)
                                    label.text = it.value.toString()
                                    label.textSize = 22F
                                    var animacion : Animation = AnimationUtils.loadAnimation(
                                            context, R.anim.animcrecer)
                                    label.startAnimation(animacion)

                                    database.child("users")
                                            .child(FirebaseAuth.getInstance().currentUser.uid)
                                            .child("estadisticas")
                                            .child("poker").get().addOnSuccessListener {


                                         label = view.findViewById(R.id.respuesta8)
                                        label.text = it.value.toString()
                                        label.textSize = 22F
                                        var animacion : Animation = AnimationUtils
                                                .loadAnimation(context, R.anim.animcrecer)
                                        label.startAnimation(animacion)

                                        database.child("users")
                                                .child(FirebaseAuth.getInstance().currentUser.uid)
                                                .child("estadisticas")
                                                .child("escaleraColor")
                                                .get().addOnSuccessListener {


                                             label = view.findViewById(R.id.respuesta9)
                                            label.text = it.value.toString()
                                            label.textSize = 22F
                                            var animacion : Animation = AnimationUtils
                                                    .loadAnimation(context, R.anim.animcrecer)
                                            label.startAnimation(animacion)

                                            database.child("users")
                                                    .child(FirebaseAuth.getInstance().currentUser.uid)
                                                    .child("estadisticas")
                                                    .child("escaleraReal")
                                                    .get().addOnSuccessListener {


                                                 label = view.findViewById(R.id.respuesta10)
                                                label.text = it.value.toString()
                                                label.textSize = 22F
                                                var animacion : Animation = AnimationUtils
                                                        .loadAnimation(context, R.anim.animcrecer)
                                                label.startAnimation(animacion)

                                            }.addOnFailureListener{
                                                Log.e("firebase", "Error getting data", it)
                                            }

                                        }.addOnFailureListener{
                                            Log.e("firebase", "Error getting data", it)
                                        }

                                    }.addOnFailureListener{
                                        Log.e("firebase", "Error getting data", it)
                                    }

                                }.addOnFailureListener{
                                    Log.e("firebase", "Error getting data", it)
                                }

                            }.addOnFailureListener{
                                Log.e("firebase", "Error getting data", it)
                            }

                        }.addOnFailureListener{
                            Log.e("firebase", "Error getting data", it)
                        }

                    }.addOnFailureListener{
                        Log.e("firebase", "Error getting data", it)
                    }

                }.addOnFailureListener{
                    Log.e("firebase", "Error getting data", it)
                }

            }.addOnFailureListener{
                Log.e("firebase", "Error getting data", it)
            }

        }.addOnFailureListener{
            Log.e("firebase", "Error getting data", it)
        }


        binding.botonreset.setOnClickListener(){
            findNavController().navigate(R.id.action_estadisticas_to_resetear)
        }
        binding.NuevaConsulta.setOnClickListener(){
            findNavController().navigate(
                    R.id.action_estadisticas_to_visualizarCartasSeleccionadasFragment)
        }
            return view
        }
    }
