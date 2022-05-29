package org.honggoii.bookcheck.adpater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import org.honggoii.bookcheck.databinding.BookItemViewBinding
import org.honggoii.bookcheck.entity.MyBook

class MyBookAdapter(val datas: List<MyBook>, private val glideRequestManager: RequestManager) : RecyclerView.Adapter<BookItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookItemViewHolder =
        BookItemViewHolder(BookItemViewBinding.inflate(LayoutInflater.from(parent.context),
        parent, false))

    override fun onBindViewHolder(holder: BookItemViewHolder, position: Int) {
        val binding = holder.binding

        datas[position].let { item ->
            with(binding) {
                glideRequestManager.load(datas[position].image).override(350, 350).into(image)
            }
        }
    }

    override fun getItemCount(): Int = datas.size

}