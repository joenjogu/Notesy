package com.joenjogu.notesy

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.joenjogu.notesy.databinding.FragmentNoteDetailBinding

class NoteDetailFragment : Fragment() {
    private lateinit var binding : FragmentNoteDetailBinding
    private val navArgs: NoteDetailFragmentArgs by navArgs()
    private val viewModel: NoteDetailViewModel by viewModels()
    private val noteId = navArgs.noteId

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_note_detail, container, false)
        setHasOptionsMenu(true)

        viewModel.getNote(noteId).observe(viewLifecycleOwner){
            binding.note = it
        }
        binding.noteDetailFab.setOnClickListener {
            val noteTitle = binding.noteDetailTitle.text.trim().toString()
            val noteText = binding.noteDetailText.text.trim().toString()
            if (checkEditTextsNotEmpty()) {
                val note = Note(noteTitle = noteTitle, noteText = noteText)
                viewModel.insertNote(note)
            }
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_note_detail, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.action_delete) {
            viewModel.deleteNote(noteId)
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