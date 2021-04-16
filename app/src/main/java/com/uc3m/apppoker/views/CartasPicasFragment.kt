package com.uc3m.apppoker.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.uc3m.apppoker.R
import com.uc3m.apppoker.databinding.FragmentCartasPicasBinding
import com.uc3m.apppoker.util.VariablesGlobales


class CartasPicasFragment : Fragment(){
    private lateinit var binding: FragmentCartasPicasBinding
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
         requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Evitamos que el usuario pueda navegar hacia atras
        }
        binding = FragmentCartasPicasBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.`as`.setOnClickListener(){

            val action = CartasPicasFragmentDirections.
            actionCartaspicasFragmentToVisualizarCartasSeleccionadasFragment("as")
            findNavController().navigate(action)

        }

        binding.S2.setOnClickListener(){

            val action = CartasPicasFragmentDirections.
            actionCartaspicasFragmentToVisualizarCartasSeleccionadasFragment("_2s")
            findNavController().navigate(action)

        }
        binding.S3.setOnClickListener(){

            val action = CartasPicasFragmentDirections.
            actionCartaspicasFragmentToVisualizarCartasSeleccionadasFragment("_3s")
            findNavController().navigate(action)

        }
        binding.S4.setOnClickListener(){

            val action = CartasPicasFragmentDirections.
            actionCartaspicasFragmentToVisualizarCartasSeleccionadasFragment("_4s")
            findNavController().navigate(action)

        }
        binding.S5.setOnClickListener(){

            val action = CartasPicasFragmentDirections.
            actionCartaspicasFragmentToVisualizarCartasSeleccionadasFragment("_5s")
            findNavController().navigate(action)

        }
        binding.S6.setOnClickListener(){

            val action = CartasPicasFragmentDirections.
            actionCartaspicasFragmentToVisualizarCartasSeleccionadasFragment("_6s")
            findNavController().navigate(action)

        }
        binding.S7.setOnClickListener(){

            val action = CartasPicasFragmentDirections.
            actionCartaspicasFragmentToVisualizarCartasSeleccionadasFragment("_7s")
            findNavController().navigate(action)

        }
        binding.S8.setOnClickListener(){

            val action = CartasPicasFragmentDirections.
            actionCartaspicasFragmentToVisualizarCartasSeleccionadasFragment("_8s")
            findNavController().navigate(action)

        }
        binding.S9.setOnClickListener(){

            val action = CartasPicasFragmentDirections.
            actionCartaspicasFragmentToVisualizarCartasSeleccionadasFragment("_9s")
            findNavController().navigate(action)

        }
        binding.S10.setOnClickListener(){

            val action = CartasPicasFragmentDirections.
            actionCartaspicasFragmentToVisualizarCartasSeleccionadasFragment("_0s")
            findNavController().navigate(action)

        }
        binding.js.setOnClickListener(){

            val action = CartasPicasFragmentDirections.
            actionCartaspicasFragmentToVisualizarCartasSeleccionadasFragment("js")
            findNavController().navigate(action)

        }
        binding.qs.setOnClickListener(){

            val action = CartasPicasFragmentDirections.
            actionCartaspicasFragmentToVisualizarCartasSeleccionadasFragment("qs")
            findNavController().navigate(action)

        }
        binding.ks.setOnClickListener(){

            val action = CartasPicasFragmentDirections.
            actionCartaspicasFragmentToVisualizarCartasSeleccionadasFragment("ks")
            findNavController().navigate(action)

        }


        return view
    }
    fun onClick(v: View){

    }
}
