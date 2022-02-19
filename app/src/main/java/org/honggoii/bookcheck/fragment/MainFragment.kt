package org.honggoii.bookcheck.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView

import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import org.honggoii.bookcheck.MyAdater
import org.honggoii.bookcheck.R
import org.honggoii.bookcheck.databinding.FragmentMainBinding
import org.honggoii.bookcheck.viewmodel.BookViewModel

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var myViewModel: BookViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)
        myViewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {

            /* 검색어가 변할때 마다 호출 */
            override fun onQueryTextChange(newText: String?): Boolean {
                Log.e("MainFragment", "######### onQueryTextChange 호출")
                return false
            }

            /* 검색어 작성 후 api 호출 */
            override fun onQueryTextSubmit(title: String?): Boolean {
                Log.e("MainFragment", "######### onQueryTextSubmit 호출")
                myViewModel.getBookSearch(title)
                return false
            }
        })

        // 테스트 데이터
        val datas = mutableListOf<String>()
        for (i in 1..100) {
            datas.add("Item $i")
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(binding.root.context)
        binding.recyclerView.adapter = MyAdater(datas)
        binding.recyclerView.addItemDecoration(DividerItemDecoration(binding.root.context, LinearLayoutManager.VERTICAL))

        return binding.root
    }

}