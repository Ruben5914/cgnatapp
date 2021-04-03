package com.uc3m.apppoker.views


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.uc3m.apppoker.R
import com.uc3m.apppoker.databinding.FragmentCartasDiamantesBinding
import com.uc3m.apppoker.util.VariablesGlobales

class CartasDiamantesFragment : Fragment(){
    private lateinit var binding: FragmentCartasDiamantesBinding


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartasDiamantesBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.ad.setOnClickListener(){


            val action = CartasDiamantesFragmentDirections.actionCartasdiamantesFragmentToVisualizarCartasSeleccionadasFragment("ad")

            findNavController().navigate(action)


        }


        return view
    }
}