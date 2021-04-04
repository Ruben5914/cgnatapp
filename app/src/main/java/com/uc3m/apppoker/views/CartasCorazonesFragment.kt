package com.uc3m.apppoker.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
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
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Evitamos que el usuario pueda navegar hacia atras
        }
        binding = FragmentCartasCorazonesBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.ah.setOnClickListener(){
            val action = CartasCorazonesFragmentDirections.
            actionCartascorazonesFragmentToVisualizarCartasSeleccionadasFragment("ah")
            findNavController().navigate(action)
        }
        binding.H2.setOnClickListener(){
            val action = CartasCorazonesFragmentDirections.
            actionCartascorazonesFragmentToVisualizarCartasSeleccionadasFragment("_2h")
            findNavController().navigate(action)
        }
        binding.H3.setOnClickListener(){
            val action = CartasCorazonesFragmentDirections.
            actionCartascorazonesFragmentToVisualizarCartasSeleccionadasFragment("_3h")
            findNavController().navigate(action)
        }
        binding.H4.setOnClickListener(){
            val action = CartasCorazonesFragmentDirections.
            actionCartascorazonesFragmentToVisualizarCartasSeleccionadasFragment("_4h")
            findNavController().navigate(action)
        }
        binding.H5.setOnClickListener(){
            val action = CartasCorazonesFragmentDirections.
            actionCartascorazonesFragmentToVisualizarCartasSeleccionadasFragment("_5h")
            findNavController().navigate(action)
        }
        binding.H6.setOnClickListener(){
            val action = CartasCorazonesFragmentDirections.
            actionCartascorazonesFragmentToVisualizarCartasSeleccionadasFragment("_6h")
            findNavController().navigate(action)
        }
        binding.H7.setOnClickListener(){
            val action = CartasCorazonesFragmentDirections.
            actionCartascorazonesFragmentToVisualizarCartasSeleccionadasFragment("_7h")
            findNavController().navigate(action)
        }
        binding.H8.setOnClickListener(){
            val action = CartasCorazonesFragmentDirections.
            actionCartascorazonesFragmentToVisualizarCartasSeleccionadasFragment("_8h")
            findNavController().navigate(action)
        }
        binding.H9.setOnClickListener(){
            val action = CartasCorazonesFragmentDirections.
            actionCartascorazonesFragmentToVisualizarCartasSeleccionadasFragment("_9h")
            findNavController().navigate(action)
        }
        binding.H10.setOnClickListener(){
            val action = CartasCorazonesFragmentDirections.
            actionCartascorazonesFragmentToVisualizarCartasSeleccionadasFragment("_0h")
            findNavController().navigate(action)
        }
        binding.jh.setOnClickListener(){
            val action = CartasCorazonesFragmentDirections.
            actionCartascorazonesFragmentToVisualizarCartasSeleccionadasFragment("jh")
            findNavController().navigate(action)
        }
        binding.qh.setOnClickListener(){
            val action = CartasCorazonesFragmentDirections.
            actionCartascorazonesFragmentToVisualizarCartasSeleccionadasFragment("qh")
            findNavController().navigate(action)
        }
        binding.kh.setOnClickListener(){
            val action = CartasCorazonesFragmentDirections.
            actionCartascorazonesFragmentToVisualizarCartasSeleccionadasFragment("kh")
            findNavController().navigate(action)
        }


        return view
    }
}