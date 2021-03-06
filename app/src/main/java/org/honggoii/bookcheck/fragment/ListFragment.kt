package org.honggoii.bookcheck.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import org.honggoii.bookcheck.Database.MyBookDatabase
import org.honggoii.bookcheck.R
import org.honggoii.bookcheck.adpater.MyBookAdapter
import org.honggoii.bookcheck.databinding.FragmentListBinding
import org.honggoii.bookcheck.viewmodel.BookViewModel
import org.honggoii.bookcheck.viewmodel.BookViewModelFactory

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var myViewModel: BookViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
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

        binding.viewModel?.myBook?.observe(viewLifecycleOwner) {
            val datas = it
            val gridLayoutManager = GridLayoutManager(context, 3) // 3열
            binding.recyclerView.layoutManager = gridLayoutManager
            val adapter = MyBookAdapter(datas, Glide.with(this))
            binding.recyclerView.adapter = adapter
        }
    }
}