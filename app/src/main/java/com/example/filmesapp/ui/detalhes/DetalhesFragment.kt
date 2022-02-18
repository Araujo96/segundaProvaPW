package com.example.filmesapp.ui.detalhes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.filmesapp.FilmesappApplication
import com.example.filmesapp.R
import com.example.filmesapp.databinding.FragmentDetalhesBinding


class DetalhesFragment : Fragment() {

    lateinit var binding:FragmentDetalhesBinding
    lateinit var viewmodel: DetalhesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val args: DetalhesFragmentArgs by navArgs()

        Toast.makeText(context, "${args.id}", Toast.LENGTH_SHORT).show()

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detalhes, container, false)
        val viewModelFactory = DetalhesViewModel.Factory(
            (requireActivity().application as FilmesappApplication).filmeRepository,
            args.id
        )
        viewmodel = ViewModelProvider(this, viewModelFactory).get(DetalhesViewModel::class.java)

        binding.viewmodel = viewmodel

        binding.lifecycleOwner = this

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.ajuda_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.opcao_menu_ajuda){
            Toast.makeText(context, "Ajuda da tela de Detalhes", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

}