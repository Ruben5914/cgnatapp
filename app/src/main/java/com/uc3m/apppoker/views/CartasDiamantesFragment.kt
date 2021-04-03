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

            val action = CartasDiamantesFragmentDirections.
            actionCartasdiamantesFragmentToVisualizarCartasSeleccionadasFragment("ad")

            findNavController().navigate(action)
        }
        binding.D2.setOnClickListener(){

            val action = CartasDiamantesFragmentDirections.
            actionCartasdiamantesFragmentToVisualizarCartasSeleccionadasFragment("_2d")

            findNavController().navigate(action)
        }
        binding.D3.setOnClickListener(){

            val action = CartasDiamantesFragmentDirections.
            actionCartasdiamantesFragmentToVisualizarCartasSeleccionadasFragment("_3d")

            findNavController().navigate(action)
        }
        binding.D4.setOnClickListener(){

            val action = CartasDiamantesFragmentDirections.
            actionCartasdiamantesFragmentToVisualizarCartasSeleccionadasFragment("_4d")

            findNavController().navigate(action)
        }
        binding.D5.setOnClickListener(){

            val action = CartasDiamantesFragmentDirections.
            actionCartasdiamantesFragmentToVisualizarCartasSeleccionadasFragment("_5d")

            findNavController().navigate(action)
        }
        binding.D6.setOnClickListener(){

            val action = CartasDiamantesFragmentDirections.
            actionCartasdiamantesFragmentToVisualizarCartasSeleccionadasFragment("_6d")

            findNavController().navigate(action)
        }
        binding.D7.setOnClickListener(){

            val action = CartasDiamantesFragmentDirections.
            actionCartasdiamantesFragmentToVisualizarCartasSeleccionadasFragment("_7d")

            findNavController().navigate(action)
        }
        binding.D8.setOnClickListener(){

            val action = CartasDiamantesFragmentDirections.
            actionCartasdiamantesFragmentToVisualizarCartasSeleccionadasFragment("_8d")

            findNavController().navigate(action)
        }
        binding.D9.setOnClickListener(){

            val action = CartasDiamantesFragmentDirections.
            actionCartasdiamantesFragmentToVisualizarCartasSeleccionadasFragment("_9d")

            findNavController().navigate(action)
        }
        binding.D10.setOnClickListener(){

            val action = CartasDiamantesFragmentDirections.
            actionCartasdiamantesFragmentToVisualizarCartasSeleccionadasFragment("_0d")

            findNavController().navigate(action)
        }
        binding.jd.setOnClickListener(){

            val action = CartasDiamantesFragmentDirections.
            actionCartasdiamantesFragmentToVisualizarCartasSeleccionadasFragment("jd")

            findNavController().navigate(action)
        }
        binding.qd.setOnClickListener(){

            val action = CartasDiamantesFragmentDirections.
            actionCartasdiamantesFragmentToVisualizarCartasSeleccionadasFragment("qd")

            findNavController().navigate(action)
        }

        binding.kd.setOnClickListener(){

            val action = CartasDiamantesFragmentDirections.
            actionCartasdiamantesFragmentToVisualizarCartasSeleccionadasFragment("kd")

            findNavController().navigate(action)
        }

        return view
    }
}