package org.honggoii.bookcheck.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import org.honggoii.bookcheck.Database.DBHelper
import org.honggoii.bookcheck.R
import org.honggoii.bookcheck.adpater.BookAdapter
import org.honggoii.bookcheck.databinding.FragmentListBinding
import org.honggoii.bookcheck.model.BookModel

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e("Fragement Life Cycle", "onViewCreated")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.e("Fragement Life Cycle", "onViewStateRestored")
    }

    override fun onStart() {
        super.onStart()
        Log.e("Fragement Life Cycle", "onStart")
    }

    override fun onResume() {
        super.onResume()

        val cursor = DBHelper(requireContext()).writableDatabase.rawQuery(
            "select * from USER", null
        )

        val myBook: ArrayList<BookModel> = ArrayList()
        while(cursor.moveToNext()) {
            myBook.add(BookModel(title = cursor.getString(1), image = cursor.getString(2)))
        }

        val gridLayoutManager = GridLayoutManager(context, 2) // 2열
        binding.recyclerView.layoutManager = gridLayoutManager
        val adapter = BookAdapter(myBook, Glide.with(this))
        binding.recyclerView.adapter = adapter


        Log.e("Fragement Life Cycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Fragement Life Cycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Fragement Life Cycle", "onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.e("Fragement Life Cycle", "onSaveInstanceState")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("Fragement Life Cycle", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Fragement Life Cycle", "onDestroy")
    }
}