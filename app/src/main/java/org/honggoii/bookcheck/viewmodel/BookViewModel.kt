package org.honggoii.bookcheck.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.honggoii.bookcheck.data.Book
import org.honggoii.bookcheck.network.BookSearchApi
import java.net.URLDecoder

class BookViewModel : ViewModel() {
    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books

    fun getBookSearch(query: String, start: Int) {
        viewModelScope.launch {
            try {
                val bookSearchResult = BookSearchApi.retrofitService.getBooks(query = URLDecoder.decode(query, "UTF-8"), start = start)
                Log.e(TAG, bookSearchResult.toString())
            } catch (e: Exception) {

            }
        }
    }

    companion object {
        const val TAG = "BookViewModel"
    }
}