package com.uc3m.apppoker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import com.uc3m.apppoker.databinding.FragmentVisualizarCartasSeleccionadasBinding


class visualizarCartasSeleccionadasFragment : Fragment() {




    private lateinit var binding: FragmentVisualizarCartasSeleccionadasBinding


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVisualizarCartasSeleccionadasBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.anadirCarta1Mesa.setOnClickListener(){
             findNavController().navigate(R.id.action_visualizarCartasSeleccionadasFragment_to_elegirPaloFragment)
        }


        return view
    }




}