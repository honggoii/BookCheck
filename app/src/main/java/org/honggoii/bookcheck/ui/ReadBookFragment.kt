package org.honggoii.bookcheck.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import org.honggoii.bookcheck.BookCheckApplication
import org.honggoii.bookcheck.adpater.MyBookAdapter
import org.honggoii.bookcheck.databinding.FragmentListBinding
import org.honggoii.bookcheck.viewmodel.BookViewModel
import org.honggoii.bookcheck.viewmodel.BookViewModelFactory

class ReadBookFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel: BookViewModel by activityViewModels{
        BookViewModelFactory(
            (activity?.application as BookCheckApplication).database.myBookDao()
        )
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.myBooks.observe(viewLifecycleOwner) {
            val readBookList = it
            val gridLayoutManager = GridLayoutManager(context, 3) // 3열
            binding.recyclerView.layoutManager = gridLayoutManager
            val adapter = MyBookAdapter(readBookList, Glide.with(this))
            binding.recyclerView.adapter = adapter
        }
    }
}