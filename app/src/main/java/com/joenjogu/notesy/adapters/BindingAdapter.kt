package com.joenjogu.notesy.adapters

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import java.util.*

@BindingAdapter("setAdapter")
fun RecyclerView.bindRecyclerViewAdapter(adapter: RecyclerView.Adapter<*>) {
    this.run {
        setHasFixedSize(true)
        this.adapter = adapter
    }
}

@BindingAdapter("setDate")
fun TextView.setDate(int: Int) {
    // TODO convert epoch to date
    val date = Date(int.toLong())
    this.text = date.toString()
}

@BindingAdapter("setTemp")
fun TextView.setTemperature(temp: Double) {
    this.text = temp.toString()
}