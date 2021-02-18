package com.joenjogu.notesy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
//import com.joenjogu.notesy.HomeFragmentDirections
import com.joenjogu.notesy.databinding.NoteListItemBinding
import com.joenjogu.notesy.models.Note

class NoteListAdapter : ListAdapter<Note, NoteListAdapter.NoteViewHolder>(DiffComparator){

    class NoteViewHolder(private val binding: NoteListItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

            fun bind(note: Note, clickListener: View.OnClickListener) {
                binding.note = note
                binding.clickListener = clickListener
                binding.executePendingBindings()
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = NoteListItemBinding.inflate(inflater, parent, false)

        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = getItem(position)
        holder.bind(note, createOnClickListener(note.id))
    }

    private fun createOnClickListener(id: Int): View.OnClickListener {
        return View.OnClickListener {
//            val direction = HomeFragmentDirections.actionHomeFragmentToNoteDetailFragment(id)
//            it.findNavController().navigate(direction)
        }
    }

    object DiffComparator : DiffUtil.ItemCallback<Note>() {
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
        }

    }
}