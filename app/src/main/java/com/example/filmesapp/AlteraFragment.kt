package com.example.filmesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.filmesapp.databinding.FragmentAlteraBinding



class AlteraFragment : Fragment() {
    lateinit var binding: FragmentAlteraBinding
    lateinit var viewmodel: AlteraViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)
        viewmodel = ViewModelProvider(this).get(AlteraViewModel::class.java)

        binding.viewmodel = viewmodel
        binding.lifecycleOwner = this

        binding.botaoAlterar.setOnClickListener{
            viewmodel.alteraPessoa()
        }

        return binding.root

    }

}