package org.honggoii.bookcheck.network

import com.squareup.moshi.JsonClass
import org.honggoii.bookcheck.data.Book

@JsonClass(generateAdapter = true)
data class SearchResponse(
    // 네이버 도서 검색 API
    val total: Int, // 검색 결과 총 개수
    val start: Int, // 검색 결과 시작점
    val display: Int, // 검색된 검색 결과 개수
    val items:List<Book>?, // 검색 결과
)
