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
                // todo 에러 처리 (https://developers.naver.com/docs/serviceapi/search/book/book.md#%EC%B1%85)
                val bookSearchResult = BookSearchApi.retrofitService.getBooks(query = URLDecoder.decode(query, "UTF-8"), start = start)
                _books.value = bookSearchResult.items
            } catch (e: Exception) {
                Log.e(TAG, "네이버 도서 검색 api 호출 실패")
            }
        }
    }

    companion object {
        const val TAG = "BookViewModel"
    }
}