package com.madeean.weeklyproject3no1

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.madeean.weeklyproject3no1.fragment.*

class TabAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = SemuaFragment()
            1 -> fragment = MakananFragment()
            2 -> fragment = MinumanFragment()
            3 -> fragment = ElektronikFragment()
            4 -> fragment = PakaianFragment()
        }
        return fragment as Fragment
    }

}