package org.honggoii.bookcheck

import android.app.Application
import org.honggoii.bookcheck.database.MyBookDatabase

class BookCheckApplication : Application() {
    val database: MyBookDatabase by lazy { MyBookDatabase.getDatabase(this) }
}