package com.joenjogu.notesy.adapters

import android.util.Log
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.util.*

@BindingAdapter("setDate")
fun TextView.setDate(int: Int) {
    val date = Date(int.toLong() * 1000).toString()
    Log.d("BindingAdapter", "setDate: $date")
    this.text = date.substring(4, 10)
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