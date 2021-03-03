package com.uc3m.apppoker.views

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.uc3m.apppoker.R
import com.uc3m.apppoker.databinding.FragmentSaveBinding
import com.uc3m.apppoker.models.Usuario
import com.uc3m.apppoker.viewModels.UsuarioViewModel



class SaveFragment : Fragment() {
/*
    private lateinit var binding: FragmentSaveBinding
    private lateinit var usuarioViewModel: UsuarioViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentSaveBinding.inflate(inflater, container, false)

        usuarioViewModel = ViewModelProvider(this).get(UsuarioViewModel::class.java)

        binding.button.setOnClickListener{
            insertDataToDatabase()
        }
        return binding.root
    }

    private fun insertDataToDatabase() {
        val firstName = binding.firstName.text.toString()
        val lastName = binding.LastName.text.toString()


        if(inputCheck(firstName, lastName)){
            val student = Usuario(0, firstName, lastName)
            usuarioViewModel.addStudent(student)
            Toast.makeText(requireContext(), "Student created", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_saveFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Fill all the fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String): Boolean {
        return !(TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName))
    }
}
*/
}
