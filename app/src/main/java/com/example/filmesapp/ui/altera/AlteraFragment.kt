package com.example.filmesapp.ui.altera

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.filmesapp.FilmesappApplication
import com.example.filmesapp.R
import com.example.filmesapp.databinding.FragmentAlteraBinding



class AlteraFragment : Fragment() {

    lateinit var binding:FragmentAlteraBinding
    lateinit var viewmodel: AlteraViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val args: AlteraFragmentArgs by navArgs()


        binding  = DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)
        val viewModelFactory =
            AlteraViewModel.Factory(
                (requireActivity().application as FilmesappApplication).filmeRepository,
                args.id)
        viewmodel = ViewModelProvider(this, viewModelFactory).get(AlteraViewModel::class.java)

        binding.viewmodel = viewmodel
        binding.lifecycleOwner = this

        viewmodel.eventAlteraFilme.observe(viewLifecycleOwner, {hasChange ->
            if(hasChange){
                Navigation
                    .findNavController(requireView())
                    .navigate(AlteraFragmentDirections.actionAlteraFragmentToHomeFragment())
                viewmodel.onAlteraFilmeCompleto()
            }

        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.ajuda_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.opcao_menu_ajuda){
            Toast.makeText(context, "Ajuda da tela de Alterar", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}