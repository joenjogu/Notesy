package com.joenjogu.notesy.adapters

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
    val date = Date(int.toLong() * 1000).toString()
    this.text = date.substring(4, 9)
}

@BindingAdapter("setDay")
fun TextView.setDay(int: Int) {
    val date = Date(int.toLong() * 1000)
    this.text = date.toString().take(4)
}

@BindingAdapter("setTemp")
fun TextView.setTemperature(temp: Double) {
    this.text = "$temp°C"
}