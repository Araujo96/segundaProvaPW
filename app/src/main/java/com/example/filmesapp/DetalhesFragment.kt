package com.example.filmesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.filmesapp.databinding.FragmentDetalhesBinding


class DetalhesFragment : Fragment() {

    lateinit var binding: FragmentDetalhesBinding
    lateinit var viewmodel:DetalhesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,  R.layout.fragment_detalhes, container, false)
        viewmodel = ViewModelProvider(this).get(DetalhesViewModel::class.java)

        binding.viewmodel  = viewmodel
        binding.lifecycleOwner = this
        return binding.root
    }

}