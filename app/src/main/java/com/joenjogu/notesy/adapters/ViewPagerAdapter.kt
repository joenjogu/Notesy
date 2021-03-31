package com.joenjogu.notesy.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.joenjogu.notesy.models.Forecast
import com.joenjogu.notesy.ui.ItemBannerFragment

class ViewPagerAdapter(
        fragmentManager: FragmentManager,
        lifecycle: Lifecycle,
        private val forecastList: List<Forecast>
        ) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return forecastList.size
    }

    override fun createFragment(position: Int): Fragment {
        val forecast = forecastList[position]
        return ItemBannerFragment(forecast)
    }
}