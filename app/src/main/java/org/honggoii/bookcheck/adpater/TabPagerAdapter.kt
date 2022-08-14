package org.honggoii.bookcheck.adpater

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.honggoii.bookcheck.ui.MainFragment

class TabPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    private val fragments: List<Fragment>
    init {
        fragments = listOf(MainFragment(), MainFragment(), MainFragment())
    }

    override fun getItemCount(): Int = fragments.size
    override fun createFragment(position: Int): Fragment = fragments[position]
}