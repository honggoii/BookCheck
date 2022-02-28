package org.honggoii.bookcheck.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_book")
data class MyBook(
    @ColumnInfo(name = "title")
    val title: String = "", // 책 제목

    @ColumnInfo(name = "image")
    val image: String = "", // 책 표지

    @ColumnInfo(name = "code")
    val code: String = "", // 분류 코드

    @ColumnInfo(name = "code_name")
    val codeName: String = "", // 분류 명
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
