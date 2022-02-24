package org.honggoii.bookcheck.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.honggoii.bookcheck.BookAPI
import org.honggoii.bookcheck.api.CommonAPI
import org.honggoii.bookcheck.model.BookModel
import org.honggoii.bookcheck.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URLDecoder

class BookViewModel : ViewModel() {
    private val _book = MutableLiveData<List<BookModel>>()
    val book: LiveData<List<BookModel>>
        get() = _book

    fun getBookSearch(query: String?) {
        BookAPI.retrofitService.getSearch(query = URLDecoder.decode(query, "UTF-8")).enqueue(
            object: Callback<SearchResponse> {
                override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                    Log.e("MainActivity", "성공 ##### ${response.body()}")
//                    _book.value = response.body()?.result
                    _book.value = response.body()?.items
                }

                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                    Log.e("MainActivity", "${t.message}")
//                    _book.value = "Failure: " + t.message
                }
            }
        )
    }
}