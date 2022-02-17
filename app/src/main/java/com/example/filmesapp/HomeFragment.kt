package com.example.filmesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.filmesapp.databinding.ActivityMainBinding
import com.example.filmesapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding:FragmentHomeBinding
    lateinit var viewModel:HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        val adapter = FilmeAdapter()

        binding.recyclerView.adapter = adapter

        viewModel.list.observe(viewLifecycleOwner,  {
            adapter.list = it
            adapter.notifyDataSetChanged()
        })

        binding.recyclerView.addOnItemTouchListener(RecyclerViewClickListener(binding.recyclerView, object : RecyclerViewClickListener.OnItemClickListener{
            override fun onItemClick(view: View, position: Int) {
                Navigation.findNavController(binding.recyclerView).navigate(R.id.action_homeFragment_to_detalhesFragment)
            }

            override fun onItemLongClick(view: View, position: Int) {
                Navigation.findNavController(binding.recyclerView).navigate(R.id.action_homeFragment_to_alteraFragment)
            }
        }))


        setHasOptionsMenu(true)
        return binding.root
    }


}
