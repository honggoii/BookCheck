package org.honggoii.bookcheck.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Book(
    // 네이버 도서 검색 API
    val title: String = "", // 검색 결과 책 제목
    val image: String = "", // 썸네일 이미지의 URL
    val author: String = "", // 저자
    val publisher: String = "", // 출판사
    val pubdate: String = "", // 출간일
    val isbn: String = "", // ISBN 넘버
    val description: String = "", // 검색 결과 책 내용 요약
)
