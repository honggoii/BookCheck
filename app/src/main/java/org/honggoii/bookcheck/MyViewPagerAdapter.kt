package org.honggoii.bookcheck

import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.honggoii.bookcheck.activity.MainActivity
import org.honggoii.bookcheck.fragment.MainFragment
import org.honggoii.bookcheck.fragment.ResultFragment

class MyViewPagerAdapter(activity: MainActivity): FragmentStateAdapter(activity) {
    val fragments: List<Fragment>
    init {
        fragments = listOf(MainFragment(), ListFragment(), ResultFragment())
    }

    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position]
}