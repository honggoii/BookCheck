package org.honggoii.bookcheck.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import org.honggoii.bookcheck.MyAdater
import org.honggoii.bookcheck.R
import org.honggoii.bookcheck.databinding.FragmentListBinding
import org.honggoii.bookcheck.databinding.FragmentMainBinding

class ListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentListBinding.inflate(inflater, container, false)

        /* RecyclerView 가상 데이터 */
        val datas = mutableListOf<String>()
        for (i in 1..10) {
            datas.add("Item $i")
        }

        val layoutManager = LinearLayoutManager(activity)
        binding.recyclerView.layoutManager = layoutManager
        val adapter = MyAdater(datas)
        binding.recyclerView.adapter = adapter

        return binding.root
    }

}