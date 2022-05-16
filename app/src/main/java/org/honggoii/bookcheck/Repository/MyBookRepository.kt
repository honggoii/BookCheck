package org.honggoii.bookcheck.Repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
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
}