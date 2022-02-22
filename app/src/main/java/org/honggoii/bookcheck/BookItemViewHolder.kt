package org.honggoii.bookcheck

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookItemViewHolder(val itemView: View) : RecyclerView.ViewHolder(itemView) {
    val img: ImageView = itemView.findViewById(R.id.image) // 책 이미지
    val title: TextView = itemView.findViewById(R.id.title) // 책 제목
}