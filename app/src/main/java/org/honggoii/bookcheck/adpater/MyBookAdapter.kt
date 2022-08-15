package org.honggoii.bookcheck.adpater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import org.honggoii.bookcheck.database.MyBook
import org.honggoii.bookcheck.databinding.BookItemViewBinding

class MyBookAdapter(private val myBooks: List<MyBook>, private val glideRequestManager: RequestManager) : RecyclerView.Adapter<MyBookAdapter.BookItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookItemViewHolder =
        BookItemViewHolder(BookItemViewBinding.inflate(LayoutInflater.from(parent.context),
        parent, false))

    override fun onBindViewHolder(holder: BookItemViewHolder, position: Int) {
        val binding = holder.binding

        myBooks[position].let { item ->
            with(binding) {
                glideRequestManager.load(myBooks[position].image).override(350, 350).into(image)
            }
        }
    }

    override fun getItemCount(): Int = myBooks.size

    class BookItemViewHolder(val binding: BookItemViewBinding) : RecyclerView.ViewHolder(binding.root)
}