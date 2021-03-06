package org.honggoii.bookcheck.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import org.honggoii.bookcheck.BookAPI
import org.honggoii.bookcheck.Database.MyBookDatabase
import org.honggoii.bookcheck.dao.MyBookDao
import org.honggoii.bookcheck.entity.MyBook
import org.honggoii.bookcheck.model.BookModel
import org.honggoii.bookcheck.model.MyBookModel
import org.honggoii.bookcheck.model.MyBookResponse
import org.honggoii.bookcheck.model.SearchResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URLDecoder

class BookViewModel(val database: MyBookDao, application: Application) : AndroidViewModel(application) {
    private val _book = MutableLiveData<List<BookModel>>()
    val book: LiveData<List<BookModel>>
        get() = _book

    val myBook: LiveData<List<MyBook>>
        get() = database.getAll()

    val code0: LiveData<Float>
        get() = database.getCode0()
    val code1: LiveData<Float>
        get() = database.getCode1()
    val code2: LiveData<Float>
        get() = database.getCode2()
    val code3: LiveData<Float>
        get() = database.getCode3()
    val code4: LiveData<Float>
        get() = database.getCode4()
    val code5: LiveData<Float>
        get() = database.getCode5()
    val code6: LiveData<Float>
        get() = database.getCode6()
    val code7: LiveData<Float>
        get() = database.getCode7()
    val code8: LiveData<Float>
        get() = database.getCode8()
    val code9: LiveData<Float>
        get() = database.getCode9()

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

    fun getMyBook(kwd: String, isbn: String, book: BookModel) {
        BookAPI.retrofitService2.getMyBook(kwd = kwd, isbn = isbn).enqueue(
            object: Callback<MyBookResponse> {
                override fun onResponse(call: Call<MyBookResponse>, response: Response<MyBookResponse>) {
                    Log.e("MainActivity", "중앙 도서관 api 호출 성공 ##### ${response.body()}")
                    val tmp = response.body()?.result?.get(0)
                    viewModelScope.launch {
                        val book = tmp?.let { MyBook(book.title, book.image, it.kdcCode1s, it.kdcName1s) }
                        database.insert(book)
                    }
                }

                override fun onFailure(call: Call<MyBookResponse>, t: Throwable) {
                    Log.e("MainActivity", "${t.message}")
                }
            }
        )
    }
}