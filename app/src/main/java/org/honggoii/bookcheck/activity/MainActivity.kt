package org.honggoii.bookcheck.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import org.honggoii.bookcheck.R
import org.honggoii.bookcheck.databinding.ActivityMainBinding
import org.honggoii.bookcheck.viewmodel.BookViewModel

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle

    private lateinit var myViewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        myViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        binding.button.setOnClickListener {
            myViewModel.getBookSearch()
        }

        myViewModel.book.observe(this, {
//            binding.textView.text = it.category
        })
//        /* View Binding */
//        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)

//
//        /* Toolbar */
//        setSupportActionBar(binding.toolbar)
//
//        /* ActionBarDrawerToggle 버튼 적용 */
//        toggle = ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_opened, R.string.drawer_closed)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        toggle.syncState()
//
//        /* 뷰 페이저 어댑터 */
//        val adapter = MyViewPagerAdapter(this)
//        binding.viewpager.adapter = adapter


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)

        val menuItem = menu?.findItem(R.id.menu_search)
        val searchView = menuItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextChange(p0: String?): Boolean {
                // 검색어 변경 이벤트
                return true
            }

            override fun onQueryTextSubmit(p0: String?): Boolean {
                // 키보드의 검색 버튼 클릭한 순간의 이벤트
                return true
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}