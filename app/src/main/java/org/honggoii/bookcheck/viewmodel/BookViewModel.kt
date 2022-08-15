package org.honggoii.bookcheck.viewmodel

import android.util.Log
import androidx.lifecycle.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import org.honggoii.bookcheck.data.Book
import org.honggoii.bookcheck.data.BookCode
import org.honggoii.bookcheck.database.MyBook
import org.honggoii.bookcheck.database.MyBookDao
import org.honggoii.bookcheck.network.BookIsbnResponse
import org.honggoii.bookcheck.network.BookSearchApi
import java.net.URLDecoder

class BookViewModel(private val myBookDao: MyBookDao) : ViewModel() {
    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books

    private val _myBooks = MutableLiveData<List<MyBook>>()
    val myBooks: LiveData<List<MyBook>> = _myBooks

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

    fun getBookIsbn(isbn: String, book: Book) {
        viewModelScope.launch {
            try {
                val bookIsbnResult = BookSearchApi.retrofitService2.getBookCode(isbn = isbn)
                insertMyBook(MyBook(title = book.title, image = book.image, code = bookIsbnResult.result[0].kdcCode1s, codeName = bookIsbnResult.result[0].kdcName1s))
            } catch (e: Exception) {
                Log.e(TAG, "중앙 도서관 검색 api 호출 실패 :: ${e.message}")
            }
        }
    }

    private fun insertMyBook(myBook: MyBook) {
        viewModelScope.launch {
            myBookDao.insert(myBook)
        }
    }

    fun getMyBookList(): Flow<List<MyBook>> = myBookDao.getAll()

    companion object {
        const val TAG = "BookViewModel"
    }
}

class BookViewModelFactory(private val myBookDao: MyBookDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BookViewModel(myBookDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}