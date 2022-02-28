package org.honggoii.bookcheck.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MyBookModel(
    // 국립 중앙 도서관 검색 API
    val titleInfo: String, // 책 제목
    val authorInfo: String, // 작가
    val pubInfo: String, // 출판사
    val pubYearInfo: String, // 발행년도 사항
    val isbn: String, // isbn
    val kdcCode1s: String, // 대분류 코드
    val kdcName1s: String, // 대분류 명칭

    var image: String = "", // 책 표지
)
