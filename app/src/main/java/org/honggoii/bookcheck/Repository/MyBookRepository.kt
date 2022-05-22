package org.honggoii.bookcheck.Repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.honggoii.bookcheck.Database.MyBookDatabase
import org.honggoii.bookcheck.dao.MyBookDao
import org.honggoii.bookcheck.entity.MyBook

class MyBookRepository(application: Application) {
    val myBookListResults = MutableLiveData<List<MyBook>>()

    private var myBookDao: MyBookDao?
    init {
        val db: MyBookDatabase? = MyBookDatabase.getInstance(application)
        myBookDao = db?.myBookDao() // 데이터베이스 인스턴스를 통해 dao 참조
    }

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    fun insertMyBook(newBook: MyBook) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newBook)
        }
    }

    private suspend fun asyncInsert(myBook: MyBook) {
        myBookDao?.insert(myBook)
    }
}