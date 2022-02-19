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

class BookViewModel : ViewModel() {
    private val _book = MutableLiveData<List<BookModel>>()
    val book: LiveData<List<BookModel>>
        get() = _book

    fun getBookSearch() {
        BookAPI.retrofitService.getSearch().enqueue(
            object: Callback<SearchResponse> {
                override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                    Log.e("MainActivity", "성공 ##### ${response.body()}")
                    _book.value = response.body()?.result
                }

                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                    Log.e("MainActivity", "${t.message}")
//                    _book.value = "Failure: " + t.message
                }
            }
        )
    }
}