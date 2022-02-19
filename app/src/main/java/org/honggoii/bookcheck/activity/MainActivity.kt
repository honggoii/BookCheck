package org.honggoii.bookcheck.activity

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import org.honggoii.bookcheck.R
import org.honggoii.bookcheck.adpater.TabPagerAdapter
import org.honggoii.bookcheck.databinding.ActivityMainBinding
import org.honggoii.bookcheck.viewmodel.BookViewModel

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle

    private lateinit var binding: ActivityMainBinding
    private lateinit var myViewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        myViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

//        binding.button.setOnClickListener {
//            myViewModel.getBookSearch()
//        }

        myViewModel.book.observe(this, {
//            binding.textView.text = it.category
        })
//        /* View Binding */
//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)


        /* Toolbar */
        setSupportActionBar(binding.toolbar)

//        /* ActionBarDrawerToggle 버튼 적용 */
//        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened, R.string.drawer_closed)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        toggle.syncState()
//
        createTabLayout () // 탭 레이아웃 생성하기

//        /* 뷰 페이저 어댑터 */
//        val adapter = MyViewPagerAdapter(this)
//        binding.viewpager.adapter = adapter
    }

    private fun createTabLayout() {
        repeat(3) {
            binding.tabLayout.addTab(binding.tabLayout.newTab())
        }

        val adapter = TabPagerAdapter(this)
        binding.viewpager.adapter = adapter

        val tabText = arrayOf("1번 탭", "2번 탭", "3번 탭")
        // 탭과 선택된 프래그먼트 동기화
        TabLayoutMediator(binding.tabLayout, binding.viewpager) {tab, position ->
            tab.text = tabText[position]
        }.attach()
    }
}