package com.uc3m.apppoker.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.uc3m.apppoker.R
import com.uc3m.apppoker.databinding.FragmentCartasCorazonesBinding



class cartasCorazonesFragment : Fragment() {
    private lateinit var binding: FragmentCartasCorazonesBinding


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartasCorazonesBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.uno.setOnClickListener(){
            findNavController().navigate(R.id.action_cartascorazonesFragment_to_visualizarCartasSeleccionadasFragment)
        }


        return view
    }
}