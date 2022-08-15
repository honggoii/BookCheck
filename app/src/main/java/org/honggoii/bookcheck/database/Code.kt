package org.honggoii.bookcheck.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "my_book")
data class Code(
    @NonNull @ColumnInfo(name = "code") val code: Int, // 코드
    @NonNull @ColumnInfo(name = "COUNT(*)") val count: Int, // 각 코드별 개수
)
