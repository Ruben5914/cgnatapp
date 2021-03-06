package com.uc3m.cgnnatsapp.views

import android.content.Intent
import android.os.Bundle

import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.activity.addCallback
import androidx.appcompat.widget.AppCompatButton

import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.uc3m.cgnnatsapp.R
import com.uc3m.cgnnatsapp.databinding.FragmentPrincipalBinding





class Principal : Fragment() {

    private lateinit var binding: FragmentPrincipalBinding
    private lateinit var auth : FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient

    companion object{
        private const val RC_SIGN_IN = 120
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Evitamos que el usuario pueda navegar hacia atras
        }
        binding = FragmentPrincipalBinding.inflate(inflater, container, false)
        val view = binding.root
        var animacion :Animation = AnimationUtils.loadAnimation(context,R.anim.animdeslizar)
        var titulo: TextView = view.findViewById(R.id.tituloApp)
        titulo.startAnimation(animacion)


        var boton : AppCompatButton = view.findViewById(R.id.botonSignIn)
        var animacion2 : Animation = AlphaAnimation(0.0f,1.0f)
        animacion2.duration = 5000
        boton.startAnimation(animacion2)

        var texto : TextView = view.findViewById(R.id.mensajeInformativoInicioSesion)
        texto.startAnimation(animacion2)

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser



        if(user != null){


                    findNavController().navigate(R.id.action_principal_to_visualizarCartasSeleccionadasFragment)

        }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireContext(), gso)

        binding.botonSignIn.setOnClickListener(){
            signIn()



        }




        return view
    }

    private fun signIn() {

        val signInIntent = googleSignInClient.signInIntent

        startActivityForResult(signInIntent, RC_SIGN_IN)

    }

    override fun onActivityResult(
            requestCode: Int,
            resultCode: Int,
            data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d("Fragment Login", "firebaseAuthWithGoogle:" + account.id)

                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w("Fragment Login", "Google sign in failed", e)
                // ...
            }
        }
    }
    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("Fragment Login", "signInWithCredential:success")
                        val user = auth.currentUser
                        if(user != null){

                                    findNavController().navigate(R.id.action_principal_to_visualizarCartasSeleccionadasFragment)

                        }
                    } else {
                        Log.w("Fragment Login", "signInWithCredential:failure", task.exception)
                    }
                }
    }

}