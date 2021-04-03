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
            val action = CartasTrebolesFragmentDirections.actionCartastrebolesFragmentToVisualizarCartasSeleccionadasFragment("AC")
            findNavController().navigate(action)
           // findNavController().navigate(R.id.action_cartascorazonesFragment_to_visualizarCartasSeleccionadasFragment)
        }


        return view
    }
}