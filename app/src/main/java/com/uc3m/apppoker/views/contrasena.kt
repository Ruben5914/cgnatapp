package com.uc3m.apppoker.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.uc3m.apppoker.R
import com.uc3m.apppoker.databinding.FragmentContrasenaBinding

import com.uc3m.apppoker.viewModels.EncryptModel


class contrasena : Fragment() {

    private lateinit var binding: FragmentContrasenaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Evitamos que el usuario pueda navegar hacia atras
        }
        binding = FragmentContrasenaBinding.inflate(inflater, container, false)
        val view = binding.root
        var contrasena1: EditText = view.findViewById(R.id.editTextTextPassword)

        var contrasena2: EditText = view.findViewById(R.id.editTextTextPassword2)

        var encabezado: TextView = view.findViewById(R.id.textocontrasena1)
        var encabezado1: TextView = view.findViewById(R.id.textocontrasena2)
        var encabezado2: TextView = view.findViewById(R.id.textocontrasena3)
        var boton: Button = view.findViewById(R.id.botonconfirmarcontrasena)
        var animacion2 : Animation = AlphaAnimation(0.0f,1.0f)
        animacion2.duration = 5000

        boton.startAnimation(animacion2)
        encabezado.startAnimation(animacion2)
        encabezado1.startAnimation(animacion2)
        encabezado2.startAnimation(animacion2)
        contrasena1.startAnimation(animacion2)
        contrasena2.startAnimation(animacion2)
        binding.botonconfirmarcontrasena.setOnClickListener(){


            if (contrasena1.text.toString() == contrasena2.text.toString()){
                val database = Firebase.database.reference
                database.child("users").child(FirebaseAuth.getInstance().currentUser.uid).child("contraseña").setValue(EncryptModel.generateStorngPasswordHash(contrasena1.text.toString()))
                findNavController().navigate(R.id.action_contrasena_to_visualizarCartasSeleccionadasFragment)


            }else{
                Toast.makeText(context, "La contraseña no coincide", Toast.LENGTH_SHORT).show()
            }


        }





        return view
    }




}