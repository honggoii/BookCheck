package org.honggoii.bookcheck.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MyBookResponse(
    // 국립 중앙도서관 API
    val total: Int, // 검색 건수
    val kwd: String, // 검색어
    val pageNum: Int, // 현재페이지
    val pageSize: Int, // 쪽당출력건수 (기본 10건)
    val category: String, // 카테고리
    val sort: String, // 정렬
    val result:List<MyBookModel>?,
)
