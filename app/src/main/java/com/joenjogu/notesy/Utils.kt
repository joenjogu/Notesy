package com.joenjogu.notesy

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

const val NAIROBI_CITY_LAT = -1.28333
const val NAIROBI_CITY_LONG = 36.816669
const val API_KEY = "e33c780968e0596428b360e55c69db6d"

fun View.hideKeyboard(context: Context) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun View.showKeyboard(context: Context) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}
