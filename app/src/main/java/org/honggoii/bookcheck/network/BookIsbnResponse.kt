package org.honggoii.bookcheck.network

import com.squareup.moshi.JsonClass
import org.honggoii.bookcheck.data.BookCode

@JsonClass(generateAdapter = true)
data class BookIsbnResponse(
    // 국립 중앙도서관 API
    val result:List<BookCode>,
)
