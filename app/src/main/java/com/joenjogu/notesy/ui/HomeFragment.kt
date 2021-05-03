package com.joenjogu.notesy.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.joenjogu.notesy.R
import com.joenjogu.notesy.adapters.NoteListAdapter
import com.joenjogu.notesy.adapters.ViewPagerAdapter
import com.joenjogu.notesy.databinding.FragmentHomeBinding
import com.joenjogu.notesy.viewmodels.HomeFragmentViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.math.truncate

class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private val viewModel: HomeFragmentViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        setHasOptionsMenu(true)

        val viewpager = binding.viewpager
        val tabLayout = binding.tabLayout

        val adapter = NoteListAdapter()
        binding.recyclerviewLayout.noteListRecyclerview.adapter = adapter

        viewModel.notes.observe(viewLifecycleOwner) {
            Log.d("HomeFragment", "onCreateView: $it")
            adapter.submitList(it)
        }

        viewModel.forecast.observe(viewLifecycleOwner) { forecastList ->
            Log.d("Home", "onCreateView: $forecastList")
            val viewpagerAdapter = ViewPagerAdapter(childFragmentManager, lifecycle, forecastList)
            viewpager.adapter = viewpagerAdapter

            TabLayoutMediator(tabLayout, viewpager) { _, _ ->


            }.attach()
            val currentDateTime = Calendar.getInstance().timeInMillis
            val currentEpoch = truncate((currentDateTime/1000).toDouble())
            val firstCurrentForecast = forecastList.find { forecast -> forecast.date.toDouble() >= currentEpoch }
            viewpager.currentItem = forecastList.indexOf(firstCurrentForecast) - 1
        }

        binding.fabAddNote.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToNoteDetailFragment()
            it.findNavController().navigate(direction)
        }

        return binding.root
    }
}