package org.honggoii.bookcheck.ui

import android.app.Dialog
import android.content.Context
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.honggoii.bookcheck.R

class BookDialog(context: Context) {
    private val dialog = Dialog(context)
    private lateinit var image : ImageView
    private lateinit var title : TextView
    private lateinit var author : TextView
    private lateinit var publisher : TextView
    private lateinit var positiveBtn : Button
    private lateinit var negativeBtn : Button
    private lateinit var listener : PositiveBtnClickedListener

    fun start(imageContent : String, titleContent : String, authorContent: String, publisherContent: String) {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        dialog.setContentView(R.layout.dialog_book)
        dialog.setCancelable(false)    // 다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히지 않도록 함

        image = dialog.findViewById(R.id.image)
        Glide.with(image)
            .load(imageContent)
            .override(300, 300)
            .into(image)
        title = dialog.findViewById(R.id.titleContent)
        title.text = titleContent.replace("<b>", "").replace("</b>", "")
        author = dialog.findViewById(R.id.authorContent)
        author.text = authorContent
        publisher = dialog.findViewById(R.id.publisherContent)
        publisher.text = publisherContent

        positiveBtn = dialog.findViewById(R.id.positiveBtn)
        positiveBtn.setOnClickListener {
            //TODO: 부모 액티비티로 내용을 돌려주기 위해 작성할 코드
            listener.onPositiveBtnClicked("확인을 눌렀습니다!")
            dialog.dismiss()
        }

        negativeBtn = dialog.findViewById(R.id.negativeBtn)
        negativeBtn.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    fun setOnPositiveBtnClickedListener(listener: (String) -> Unit) {
        this.listener = object: PositiveBtnClickedListener {
            override fun onPositiveBtnClicked(content: String) {
                listener(content)
            }
        }
    }

    interface PositiveBtnClickedListener {
        fun onPositiveBtnClicked(content : String)
    }
}