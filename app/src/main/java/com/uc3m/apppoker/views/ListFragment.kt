package com.uc3m.apppoker.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.uc3m.apppoker.R
import com.uc3m.apppoker.databinding.FragmentListBinding
import com.uc3m.apppoker.viewModels.UsuarioViewModel



class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var usuarioViewModel: UsuarioViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root

        val adapter = ListAdapter()
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        usuarioViewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)
        usuarioViewModel.readAll.observe(viewLifecycleOwner, {
            student -> adapter.setData(student)
        })

        binding.addButton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_saveFragment)
        }
        binding.apiContentBoton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_conexionApiFragment)
        }

        return view
    }




}