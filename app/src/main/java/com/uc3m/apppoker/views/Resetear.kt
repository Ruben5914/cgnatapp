package com.uc3m.apppoker.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.uc3m.apppoker.R
import com.uc3m.apppoker.databinding.FragmentContrasenaBinding
import com.uc3m.apppoker.databinding.FragmentResetearBinding
import com.uc3m.apppoker.models.Mano
import com.uc3m.apppoker.viewModels.EncryptModel


class Resetear : Fragment() {

    private lateinit var binding: FragmentResetearBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Evitamos que el usuario pueda navegar hacia atras
        }
        binding = FragmentResetearBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.botonresetear.setOnClickListener(){
            var contrasena: EditText = view.findViewById(R.id.editTextTextPassword3)
            val database = Firebase.database.reference
            database.child("users").child(FirebaseAuth.getInstance().currentUser.uid).child("contraseña").get().addOnSuccessListener {
               // if (EncryptModel.md5(contrasena.text.toString() )== it.value.toString()){
                if (EncryptModel.validatePassword(contrasena.text.toString(),it.value.toString())){
                    val mano = Mano ()
                    database.child("users").child(FirebaseAuth.getInstance().currentUser.uid).child("estadisticas").setValue(mano)
                    findNavController().navigate(R.id.action_resetear_to_estadisticas)
                }else{
                    Toast.makeText(context, "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener{
                Log.e("firebase", "Error getting data", it)
            }

        }
        binding.botoncancelar.setOnClickListener(){
            findNavController().navigate(R.id.action_resetear_to_estadisticas)
        }

        return view
    }
}
