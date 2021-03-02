package com.uc3m.apppoker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.uc3m.apppoker.databinding.FragmentElegirPaloBinding
import com.uc3m.apppoker.databinding.FragmentVisualizarCartasSeleccionadasBinding


class elegirPaloFragment : Fragment() {

    private lateinit var binding: FragmentElegirPaloBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentElegirPaloBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.corazon.setOnClickListener(){
            findNavController().navigate(R.id.action_elegirPaloFragment_to_cartascorazonesFragment)
        }


        return view
    }


}