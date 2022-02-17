package com.example.filmesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.filmesapp.databinding.FragmentCadastroBinding

class CadastroFragment : Fragment() {

    lateinit var binding: FragmentCadastroBinding
    lateinit var viewmodel:CadastroViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastro, container, false)
        viewmodel = ViewModelProvider(this).get(CadastroViewModel::class.java)

        binding.viewmodel = viewmodel
        binding.lifecycleOwner = this

        binding.buttonCadastrar.setOnClickListener {
            viewmodel.cadastraPessoa()
            Navigation.findNavController(it).navigate(R.id.action_cadastroFragment_to_homeFragment)
        }

        return binding.root
    }

}