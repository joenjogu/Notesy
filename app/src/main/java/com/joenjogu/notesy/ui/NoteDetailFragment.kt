package com.joenjogu.notesy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.appbar.MaterialToolbar
import com.joenjogu.notesy.R
import com.joenjogu.notesy.databinding.FragmentNoteDetailBinding
import com.joenjogu.notesy.hideKeyboard
import com.joenjogu.notesy.models.Note
import com.joenjogu.notesy.viewmodels.NoteDetailViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class NoteDetailFragment : Fragment() {
    private lateinit var binding: FragmentNoteDetailBinding
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

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_note_detail,
            container,
            false
        )

        viewModel.getNote(navArgs.noteId).observe(viewLifecycleOwner) {
            binding.note = it
        }
//        binding.noteDetailTitle.requestFocus()
//        binding.noteDetailTitle.showKeyboard(requireContext())
        binding.noteDetailFab.setOnClickListener {
            val noteTitle = binding.noteDetailTitle.text.trim().toString()
            val noteText = binding.noteDetailText.text.trim().toString()
            if (checkEditTextsNotEmpty()) {
                val note = Note(noteTitle = noteTitle, noteText = noteText)
                viewModel.insertNote(note)
                Toast.makeText(requireContext(), getString(R.string.add_note_successful), Toast.LENGTH_LONG).show()
                it.hideKeyboard(requireContext())
                val direction = NoteDetailFragmentDirections.actionNoteDetailFragmentToHomeFragment()
                it.findNavController().navigate(direction)
            }
        }

        initToolbar(binding.noteDetailToolbar)

        binding.noteDetailToolbar.setNavigationOnClickListener {
            navigateUp(it)
        }

        return binding.root
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

    private fun initToolbar(toolbar: MaterialToolbar) {
        toolbar.inflateMenu(R.menu.menu_note_detail)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_delete -> {
                    deleteNoteWithDialog()
                    true
                }
                else -> false
            }
        }
    }

    private fun deleteNoteWithDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Delete Note")
            .setMessage("Are you sure you want to delete this note?")
            .setPositiveButton("YES"
            ) { dialog, _ ->
                viewModel.deleteNote(navArgs.noteId)
                Toast.makeText(
                    requireContext(),
                    getString(R.string.note_deleted),
                    Toast.LENGTH_LONG
                ).show()
                dialog.dismiss()
                navigateUp(binding.root)
            }
            .setNegativeButton("NO", null)
            .show()

    }

    private fun navigateUp(view: View) {
        val direction = NoteDetailFragmentDirections.actionNoteDetailFragmentToHomeFragment()
        view.findNavController().navigate(direction)
    }
}
