package org.honggoii.bookcheck.Database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, "testdb", null, 1) {
    // 앱 설치 후 한 번 호출
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE USER (" +
        "_id integer primary key autoincrement," +
        "title not null, " +
        "image)")
    }

    // DB 스키마 변경될 때 호출
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS USER")
//        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

}