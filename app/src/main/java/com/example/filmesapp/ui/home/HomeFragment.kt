package com.example.filmesapp.ui.home

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.filmesapp.FilmeAdapter
import com.example.filmesapp.R
import com.example.filmesapp.util.RecyclerViewClickListener
import com.example.filmesapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding:FragmentHomeBinding
    lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val adapter = FilmeAdapter()

        binding.recyclerView.adapter = adapter

        viewModel.list.observe(viewLifecycleOwner,  { list ->
            adapter.submitList(list)
        })

        binding.recyclerView.addOnItemTouchListener(RecyclerViewClickListener(binding.recyclerView, object : RecyclerViewClickListener.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                Navigation.findNavController(binding.recyclerView).navigate(HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(adapter.currentList[position].id))
            }

            override fun onItemLongClick(view: View, position: Int) {
                Navigation.findNavController(binding.recyclerView).navigate(HomeFragmentDirections.actionHomeFragmentToAlteraFragment(adapter.currentList[position].id))
            }
        }))


        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.ajuda_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.opcao_menu_ajuda){
            Toast.makeText(context, "Ajuda da tela de Home", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}