package org.honggoii.bookcheck.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import org.honggoii.bookcheck.R
import org.honggoii.bookcheck.adpater.TabPagerAdapter
import org.honggoii.bookcheck.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        /* Toolbar */
//        setSupportActionBar(binding.toolbar)

        createTabLayout () // 탭 레이아웃 생성하기
        setContentView(binding.root)
    }

    private fun createTabLayout() {
        repeat(3) {
            binding.tabLayout.addTab(binding.tabLayout.newTab())
        }

        val adapter = TabPagerAdapter(this)
        binding.viewpager.adapter = adapter

        val tabText = arrayOf(getString(R.string.search), getString(R.string.classification), getString(R.string.read))
        // 탭과 선택된 프래그먼트 동기화
        TabLayoutMediator(binding.tabLayout, binding.viewpager) {tab, position ->
            tab.text = tabText[position]
        }.attach()
    }
}