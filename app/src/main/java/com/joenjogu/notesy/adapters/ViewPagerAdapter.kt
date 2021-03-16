package com.joenjogu.notesy.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.joenjogu.notesy.R
import com.joenjogu.notesy.databinding.ItemBannerBinding
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