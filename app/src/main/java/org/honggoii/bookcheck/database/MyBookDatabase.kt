package org.honggoii.bookcheck.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.honggoii.bookcheck.database.MyBookDao
import org.honggoii.bookcheck.database.MyBook

@Database(entities = [MyBook::class], version = 1, exportSchema = false)
abstract class MyBookDatabase : RoomDatabase() {
    abstract fun myBookDao(): MyBookDao

    companion object {
        @Volatile
        private var INSTANCE : MyBookDatabase? = null

        fun getDatabase(context: Context) : MyBookDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    MyBookDatabase::class.java,
                    "my_book")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}