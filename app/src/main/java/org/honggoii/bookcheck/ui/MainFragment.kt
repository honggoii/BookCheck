package org.honggoii.bookcheck.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.honggoii.bookcheck.BookCheckApplication
import org.honggoii.bookcheck.adpater.BookAdapter
import org.honggoii.bookcheck.data.Book
import org.honggoii.bookcheck.databinding.FragmentMainBinding
import org.honggoii.bookcheck.viewmodel.BookViewModel
import org.honggoii.bookcheck.viewmodel.BookViewModelFactory

class MainFragment : Fragment() {

    private val viewModel: BookViewModel by activityViewModels {
        BookViewModelFactory(
            (activity?.application as BookCheckApplication).database.myBookDao()
        )
    }
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: BookAdapter

    private var query: String? = "" // 검색
    private var searchFlag: Int = 1 // 검색 시작 위치

    private val bookList: MutableList<Book> = arrayListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gridLayoutManager = GridLayoutManager(context, 3) // 3열
        binding.recyclerView.layoutManager = gridLayoutManager
        adapter = BookAdapter(bookList, Glide.with(this))
        binding.recyclerView.adapter = adapter

        bookSearch()
        bookSearchList()
    }

    private fun bookSearch() {
        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {

            /* 검색어가 변할때 마다 호출 */
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            /* 검색어 작성 후 api 호출 */
            override fun onQueryTextSubmit(title: String?): Boolean {
                query = title
                title?.let {
                    viewModel.getBookSearch(title, searchFlag)
                }
                return false
            }
        })

        binding.searchView.setOnCloseListener {
            binding.searchView.clearFocus()
            true
        }
    }

    private fun bookSearchList() {

        viewModel.books.observe(viewLifecycleOwner) {
            bookList.addAll(it)
            adapter.notifyDataSetChanged()
            adapter.setOnItemClickListener(object : BookAdapter.OnItemClickListener {
                override fun onItemClick(v: View, data: Book, position: Int) {
                    val dialog = BookDialog(requireContext())
                    dialog.setOnPositiveBtnClickedListener { content ->
                        viewModel.getBookIsbn(
                            data.isbn,
                            data
                        )
                    }
                    dialog.start(data.image, data.title, data.author, data.publisher)
                }
            })
        }

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (recyclerView.canScrollVertically(-1)) {
                    Log.e(TAG, "Get Next Page!!")
                    searchFlag++
                    query?.let {
                        viewModel.getBookSearch(it, searchFlag)
                    }
                }
            }
        })
    }

    companion object {
        const val TAG = "MainFragment"
    }
}