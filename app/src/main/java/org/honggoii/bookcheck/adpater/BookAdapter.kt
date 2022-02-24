package org.honggoii.bookcheck.adpater

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import org.honggoii.bookcheck.BookItemViewHolder
import org.honggoii.bookcheck.databinding.BookItemViewBinding
import org.honggoii.bookcheck.model.BookModel

class BookAdapter(val datas: List<BookModel>, private val glideRequestManager: RequestManager) : RecyclerView.Adapter<BookItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookItemViewHolder =
        BookItemViewHolder(BookItemViewBinding.inflate(LayoutInflater.from(parent.context),
        parent, false))

    override fun onBindViewHolder(holder: BookItemViewHolder, position: Int) {
        val binding = holder.binding
        Log.e("BookAdapter", datas[position].title)
        glideRequestManager.load(datas[position].image).override(300, 300).into(binding.image)
        binding.title.text = datas[position].title.replace("<b>", "").replace("</b>", "")
    }

    override fun getItemCount(): Int = datas.size

}