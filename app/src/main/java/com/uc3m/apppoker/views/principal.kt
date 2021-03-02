package com.uc3m.apppoker.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.uc3m.apppoker.R
import com.uc3m.apppoker.databinding.FragmentListBinding
import com.uc3m.apppoker.databinding.FragmentPrincipalBinding
import com.uc3m.apppoker.viewModels.UsuarioViewModel


class principal : Fragment() {

    private lateinit var binding: FragmentPrincipalBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPrincipalBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.botonGuest.setOnClickListener(){
             findNavController().navigate(R.id.action_principal_to_visualizarCartasSeleccionadasFragment)
        }


        return view
    }



}