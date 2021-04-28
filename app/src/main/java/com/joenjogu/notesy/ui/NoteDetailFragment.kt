package com.joenjogu.notesy.ui

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.joenjogu.notesy.R
import com.joenjogu.notesy.databinding.FragmentNoteDetailBinding
import com.joenjogu.notesy.hideKeyboard
import com.joenjogu.notesy.models.Note
import com.joenjogu.notesy.showKeyboard
import com.joenjogu.notesy.viewmodels.NoteDetailViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class NoteDetailFragment : Fragment() {
    private lateinit var binding : FragmentNoteDetailBinding
    private val navArgs: NoteDetailFragmentArgs by navArgs()
    private val viewModel: NoteDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_note_detail, container, false)
        setHasOptionsMenu(true)

        viewModel.getNote(navArgs.noteId).observe(viewLifecycleOwner){
            binding.note = it
        }
        binding.noteDetailTitle.requestFocus()
        binding.noteDetailTitle.showKeyboard(requireContext())
        binding.noteDetailFab.setOnClickListener {
            val noteTitle = binding.noteDetailTitle.text.trim().toString()
            val noteText = binding.noteDetailText.text.trim().toString()
            if (checkEditTextsNotEmpty()) {
                val note = Note(noteTitle = noteTitle, noteText = noteText)
                viewModel.insertNote(note)
                Snackbar.make(
                        binding.root,
                        getString(R.string.add_note_successful),
                        Snackbar.LENGTH_LONG
                )
                it.hideKeyboard(requireContext())
                val direction = NoteDetailFragmentDirections.actionNoteDetailFragmentToHomeFragment()
                it.findNavController().navigate(direction)
            }
        }

        binding.NoteDetailToolbar.setNavigationOnClickListener {
            val direction = NoteDetailFragmentDirections.actionNoteDetailFragmentToHomeFragment()
            it.findNavController().navigate(direction)
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_note_detail, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.action_delete) {
            viewModel.deleteNote(navArgs.noteId)
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

    private fun checkEditTextsNotEmpty(): Boolean {
        var titleText = false
        var descriptionText = false
        if (binding.noteDetailTitle.text.isEmpty()) {
            binding.noteDetailTitle.error = getString(R.string.required_field)
        } else {
            titleText = true
        }
        if (binding.noteDetailText.text.isEmpty()) {
            binding.noteDetailText.error = getString(R.string.required_field)
        } else {
            descriptionText = true
        }
        return titleText and descriptionText
    }
}