package com.joenjogu.notesy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.joenjogu.notesy.R
import com.joenjogu.notesy.databinding.ItemBannerBinding
import com.joenjogu.notesy.models.Forecast

class ItemBannerFragment(val forecast: Forecast) : Fragment() {

    private lateinit var binding: ItemBannerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.item_banner, container, false)

        binding.forecast = forecast

        setImage(forecast.iconUrl)

        return binding.root
    }

    private fun setImage(iconCode: String) {
        val iconUrl = "https://openweathermap.org/img/wn/$iconCode@2x.png"
        Glide.with(this.requireActivity()).load(iconUrl).into(binding.itemImage)
    }
}