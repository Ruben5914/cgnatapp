package com.uc3m.apppoker.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


import com.uc3m.apppoker.R
import com.uc3m.apppoker.databinding.FragmentCartasCorazonesBinding



class CartasCorazonesFragment : Fragment() {
    private lateinit var binding: FragmentCartasCorazonesBinding


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartasCorazonesBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.ah.setOnClickListener(){
            val action = CartasCorazonesFragmentDirections.actionCartascorazonesFragmentToVisualizarCartasSeleccionadasFragment("AH")
            findNavController().navigate(action)
        }


        return view
    }
}