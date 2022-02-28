package org.honggoii.bookcheck.adpater

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import org.honggoii.bookcheck.BookItemViewHolder
import org.honggoii.bookcheck.databinding.BookItemViewBinding
import org.honggoii.bookcheck.entity.MyBook
import org.honggoii.bookcheck.model.BookModel

class MyBookAdapter(val datas: List<MyBook>, private val glideRequestManager: RequestManager) : RecyclerView.Adapter<BookItemViewHolder>() {
//    interface OnItemClickListener{ // 인터페이스
//        fun onItemClick(v: View, data: BookModel, position: Int)
//    }
//    private var listener: OnItemClickListener? = null // 컴포지션
//    fun setOnItemClickListener(listener: OnItemClickListener){ // 함수
//        this.listener = listener
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookItemViewHolder =
        BookItemViewHolder(BookItemViewBinding.inflate(LayoutInflater.from(parent.context),
        parent, false))

    override fun onBindViewHolder(holder: BookItemViewHolder, position: Int) {
        val binding = holder.binding
        Log.e("BookAdapter", datas[position].title)

        datas[position].let { item ->
            with(binding) {
                glideRequestManager.load(datas[position].image).override(300, 300).into(image)
                title.text = datas[position].title.replace("<b>", "").replace("</b>", "")
//                image.setOnClickListener {
//                    listener?.onItemClick(it, item, position)
//                }
            }
        }
    }

    override fun getItemCount(): Int = datas.size

}