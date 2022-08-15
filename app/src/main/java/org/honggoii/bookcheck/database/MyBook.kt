package org.honggoii.bookcheck.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_book")
data class MyBook(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    @NonNull @ColumnInfo(name = "title") val title: String, // 책 제목
    @NonNull @ColumnInfo(name = "image") val image: String, // 책 표지
    @NonNull @ColumnInfo(name = "code") val code: String, // 분류 코드
    @NonNull @ColumnInfo(name = "code_name") val codeName: String, // 분류 명
)
