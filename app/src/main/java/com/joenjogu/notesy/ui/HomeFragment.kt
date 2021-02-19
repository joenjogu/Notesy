package com.joenjogu.notesy.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.joenjogu.notesy.adapters.NoteListAdapter
import com.joenjogu.notesy.R
import com.joenjogu.notesy.databinding.FragmentHomeBinding
import com.joenjogu.notesy.viewmodels.HomeFragmentViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private val viewModel: HomeFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        val adapter = NoteListAdapter()
//        binding.recyclerviewLayout.adapter = adapter
        binding.recyclerviewLayout.noteListRecyclerview.adapter = adapter

        viewModel.notes.observe(viewLifecycleOwner) {
            Log.d("HomeFragment", "onCreateView: $it")
            adapter.submitList(it)
        }

        binding.fabAddNote.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToNoteDetailFragment()
            it.findNavController().navigate(direction)
        }

        return binding.root
    }
}