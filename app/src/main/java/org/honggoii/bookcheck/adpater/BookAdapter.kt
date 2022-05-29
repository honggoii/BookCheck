package org.honggoii.bookcheck.adpater

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import org.honggoii.bookcheck.databinding.BookItemViewBinding
import org.honggoii.bookcheck.databinding.SearchBookItemViewBinding
import org.honggoii.bookcheck.model.BookModel

class BookAdapter(val datas: List<BookModel>, private val glideRequestManager: RequestManager) : RecyclerView.Adapter<SearchBookItemViewHolder>() {
    interface OnItemClickListener{ // 인터페이스
        fun onItemClick(v: View, data: BookModel, position: Int)
    }
    private var listener: OnItemClickListener? = null // 컴포지션
    fun setOnItemClickListener(listener: OnItemClickListener){ // 함수
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchBookItemViewHolder =
        SearchBookItemViewHolder(
            SearchBookItemViewBinding.inflate(LayoutInflater.from(parent.context),
        parent, false))

    override fun onBindViewHolder(holder: SearchBookItemViewHolder, position: Int) {
        val binding = holder.binding

        datas[position].let { item ->
            with(binding) {
                glideRequestManager.load(datas[position].image).override(400, 400).into(image)
                image.setOnClickListener {
                    listener?.onItemClick(it, item, position)
                }
            }
        }
    }

    override fun getItemCount(): Int = datas.size

}