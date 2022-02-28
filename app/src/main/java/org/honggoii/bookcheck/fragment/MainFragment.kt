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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.honggoii.bookcheck.BookDialog
import org.honggoii.bookcheck.Database.MyBookDatabase
import org.honggoii.bookcheck.R
import org.honggoii.bookcheck.adpater.BookAdapter
import org.honggoii.bookcheck.databinding.FragmentMainBinding
import org.honggoii.bookcheck.model.BookModel
import org.honggoii.bookcheck.viewmodel.BookViewModel
import org.honggoii.bookcheck.viewmodel.BookViewModelFactory

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var myViewModel: BookViewModel
    private var query: String? = ""
    private var start: Int = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = MyBookDatabase.getInstance(application).myBookDao()
        val viewModelFactory = BookViewModelFactory(dataSource, application)
        myViewModel = ViewModelProvider(this, viewModelFactory).get(BookViewModel::class.java)

        binding.setLifecycleOwner(this)
        binding.viewModel = myViewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {

            /* 검색어가 변할때 마다 호출 */
            override fun onQueryTextChange(newText: String?): Boolean {
                Log.e("MainFragment", "######### onQueryTextChange 호출")
                return false
            }

            /* 검색어 작성 후 api 호출 */
            override fun onQueryTextSubmit(title: String?): Boolean {
                Log.e("MainFragment", "######### onQueryTextSubmit 호출")
                query = title
                myViewModel.getBookSearch(title, start)
                return false
            }
        })

        myViewModel.book.observe(viewLifecycleOwner, {
            // 테스트 데이터
            val datas = it
            val gridLayoutManager = GridLayoutManager(context, 2) // 2열
            binding.recyclerView.layoutManager = gridLayoutManager
            val adapter = BookAdapter(datas, Glide.with(this))
            binding.recyclerView.adapter = adapter
//            binding.recyclerView.addItemDecoration(DividerItemDecoration(binding.root.context, LinearLayoutManager.VERTICAL))
            adapter.setOnItemClickListener(object: BookAdapter.OnItemClickListener {
                override fun onItemClick(v: View, data: BookModel, position: Int) {
                    val dialog = BookDialog(requireContext())
                    dialog.setOnPositiveBtnClickedListener{ content ->
                        // 데이터 저장
                        myViewModel.getMyBook(data.isbn.substring(data.isbn.length-13), data.image)
                    }
                    dialog.start(data.image, data.title, data.author, data.publisher)
                }
            })
        })

        binding.recyclerView.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val totalItemCount = (recyclerView.layoutManager as LinearLayoutManager).itemCount - 1
                val lastItemPosition = (recyclerView.layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()

                Log.e("##### totalItemCount", "${totalItemCount}")
                Log.e("##### lastItem", "${lastItemPosition}")

                if ((totalItemCount == lastItemPosition) && start <= 1000) {
                    start += 10
                    myViewModel.getBookSearch(query, start)
                }
            }
        })
    }

}