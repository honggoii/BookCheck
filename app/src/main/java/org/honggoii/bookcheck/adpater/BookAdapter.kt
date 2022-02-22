package org.honggoii.bookcheck.adpater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.honggoii.bookcheck.BookItemViewHolder
import org.honggoii.bookcheck.R

class BookAdapter(val datas: MutableList<String>) : RecyclerView.Adapter<BookItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.book_item_view, parent, false)
        return BookItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookItemViewHolder, position: Int) {
        holder.title.text = datas[position]
    }

    override fun getItemCount(): Int = datas.size

}