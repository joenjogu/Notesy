package com.joenjogu.notesy

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.joenjogu.notesy.databinding.FragmentNoteDetailBinding

class NoteDetailFragment : Fragment() {
    private lateinit var binding : FragmentNoteDetailBinding
    private val navArgs: NoteDetailFragmentArgs by navArgs()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_note_detail, container, false)
        setHasOptionsMenu(true)

        val noteId = navArgs.noteId

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_note_detail, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.action_delete) {
            // handle delete click
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }

}