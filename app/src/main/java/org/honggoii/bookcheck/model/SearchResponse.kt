package org.honggoii.bookcheck.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResponse(
    // 네이버 도서 검색 API
    val lastBuildDate: String, // 검색 결과를 생성한 시간
    val total: Int, // 검색 결과 총 개수
    val start: Int, // 검색 결과 시작점
    val display: Int, // 검색된 검색 결과 개수
    val items:List<BookModel>?, // 검색 결과
)
