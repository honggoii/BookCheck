package org.honggoii.bookcheck.adpater

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.honggoii.bookcheck.fragment.ListFragment
import org.honggoii.bookcheck.fragment.MainFragment
import org.honggoii.bookcheck.fragment.ResultFragment

class TabPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    val fragments: List<Fragment>
    init {
        fragments = listOf(MainFragment(), ResultFragment(), ListFragment())
    }

    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position]
}