package com.uc3m.apppoker.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.uc3m.apppoker.R
import com.uc3m.apppoker.databinding.FragmentCartasCorazonesBinding
import com.uc3m.apppoker.databinding.FragmentCartasTrebolesBinding

class CartasTrebolesFragment : Fragment(){
    private lateinit var binding: FragmentCartasTrebolesBinding


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartasTrebolesBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.ac.setOnClickListener(){
            val action = CartasTrebolesFragmentDirections.
            actionCartastrebolesFragmentToVisualizarCartasSeleccionadasFragment("ac")
            findNavController().navigate(action)
        }
        binding.C2.setOnClickListener(){
            val action = CartasTrebolesFragmentDirections.
            actionCartastrebolesFragmentToVisualizarCartasSeleccionadasFragment("_2c")
            findNavController().navigate(action)
        }
        binding.C3.setOnClickListener(){
            val action = CartasTrebolesFragmentDirections.
            actionCartastrebolesFragmentToVisualizarCartasSeleccionadasFragment("_3c")
            findNavController().navigate(action)
        }
        binding.C4.setOnClickListener(){
            val action = CartasTrebolesFragmentDirections.
            actionCartastrebolesFragmentToVisualizarCartasSeleccionadasFragment("_4c")
            findNavController().navigate(action)
        }
        binding.C5.setOnClickListener(){
            val action = CartasTrebolesFragmentDirections.
            actionCartastrebolesFragmentToVisualizarCartasSeleccionadasFragment("_5c")
            findNavController().navigate(action)
        }
        binding.C6.setOnClickListener(){
            val action = CartasTrebolesFragmentDirections.
            actionCartastrebolesFragmentToVisualizarCartasSeleccionadasFragment("_6c")
            findNavController().navigate(action)
        }
        binding.C7.setOnClickListener(){
            val action = CartasTrebolesFragmentDirections.
            actionCartastrebolesFragmentToVisualizarCartasSeleccionadasFragment("_7c")
            findNavController().navigate(action)
        }
        binding.C8.setOnClickListener(){
            val action = CartasTrebolesFragmentDirections.
            actionCartastrebolesFragmentToVisualizarCartasSeleccionadasFragment("_8c")
            findNavController().navigate(action)
        }
        binding.C9.setOnClickListener(){
            val action = CartasTrebolesFragmentDirections.
            actionCartastrebolesFragmentToVisualizarCartasSeleccionadasFragment("_9c")
            findNavController().navigate(action)
        }
        binding.C10.setOnClickListener(){
            val action = CartasTrebolesFragmentDirections.
            actionCartastrebolesFragmentToVisualizarCartasSeleccionadasFragment("_0c")
            findNavController().navigate(action)
        }
        binding.jc.setOnClickListener(){
            val action = CartasTrebolesFragmentDirections.
            actionCartastrebolesFragmentToVisualizarCartasSeleccionadasFragment("jc")
            findNavController().navigate(action)
        }
        binding.qc.setOnClickListener(){
            val action = CartasTrebolesFragmentDirections.
            actionCartastrebolesFragmentToVisualizarCartasSeleccionadasFragment("qc")
            findNavController().navigate(action)
        }
        binding.kc.setOnClickListener(){
            val action = CartasTrebolesFragmentDirections.
            actionCartastrebolesFragmentToVisualizarCartasSeleccionadasFragment("kc")
            findNavController().navigate(action)
        }



        return view
    }
}