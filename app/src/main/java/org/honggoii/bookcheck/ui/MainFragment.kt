package org.honggoii.bookcheck.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.honggoii.bookcheck.databinding.FragmentMainBinding
import org.honggoii.bookcheck.viewmodel.BookViewModel

class MainFragment : Fragment() {

    private val viewModel: BookViewModel by viewModels()
    private lateinit var binding: FragmentMainBinding

    private var query: String? = ""
    private var start: Int = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {

            /* 검색어가 변할때 마다 호출 */
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            /* 검색어 작성 후 api 호출 */
            override fun onQueryTextSubmit(title: String?): Boolean {
                query = title
                title?.let {
                    viewModel.getBookSearch(title, start)
                }
                return false
            }
        })

        binding.searchView.setOnCloseListener {
            binding.searchView.clearFocus()
            true
        }
    }

}