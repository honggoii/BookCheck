package org.honggoii.bookcheck.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.honggoii.bookcheck.dao.MyBookDao
import org.honggoii.bookcheck.entity.MyBook

@Database(entities = [MyBook::class], version = 1, exportSchema = false)
abstract class MyBookDatabase : RoomDatabase() {
    abstract fun myBookDao(): MyBookDao

    companion object {
        @Volatile
        private var INSTANCE : MyBookDatabase? = null

        fun getInstance(context: Context) : MyBookDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MyBookDatabase::class.java,
                        "my_book"
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                
                return instance
            }
        }
    }
}