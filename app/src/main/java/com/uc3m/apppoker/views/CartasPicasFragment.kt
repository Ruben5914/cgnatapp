package com.uc3m.apppoker.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        binding = FragmentCartasPicasBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.`as`.setOnClickListener(){
            //view.findNavController().navigate("AS")
            val action = CartasPicasFragmentDirections.actionCartaspicasFragmentToVisualizarCartasSeleccionadasFragment("as")

           // findNavController().navigate(R.id.action_cartaspicasFragment_to_visualizarCartasSeleccionadasFragment)
            findNavController().navigate(action)

        }


        return view
    }
    fun onClick(v: View){

    }
}
