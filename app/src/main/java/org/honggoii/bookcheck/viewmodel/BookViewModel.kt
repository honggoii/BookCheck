package org.honggoii.bookcheck.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.honggoii.bookcheck.BookAPI
import org.honggoii.bookcheck.api.CommonAPI
import org.honggoii.bookcheck.model.BookModel
import org.honggoii.bookcheck.model.MyBookModel
import org.honggoii.bookcheck.model.MyBookResponse
import org.honggoii.bookcheck.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URLDecoder

class BookViewModel : ViewModel() {
    private val _book = MutableLiveData<List<BookModel>>()
    val book: LiveData<List<BookModel>>
        get() = _book

    fun getBookSearch(query: String?, start: Int) {
        BookAPI.retrofitService.getSearch(query = URLDecoder.decode(query, "UTF-8"), start = start).enqueue(
            object: Callback<SearchResponse> {
                override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                    Log.e("MainActivity", "성공 ##### ${response.body()}")
                    _book.value = response.body()?.items
                }

                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                    Log.e("MainActivity", "${t.message}")
//                    _book.value = "Failure: " + t.message
                }
            }
        )
    }

    fun getMyBook(isbn: String) {
        BookAPI.retrofitService2.getMyBook(isbn = isbn).enqueue(
            object: Callback<MyBookResponse> {
                override fun onResponse(call: Call<MyBookResponse>, response: Response<MyBookResponse>) {
                    Log.e("MainActivity", "중앙 도서관 api 호출 성공 ##### ${response.body()}")
                }

                override fun onFailure(call: Call<MyBookResponse>, t: Throwable) {
                    Log.e("MainActivity", "${t.message}")
                }
            }
        )
    }
}