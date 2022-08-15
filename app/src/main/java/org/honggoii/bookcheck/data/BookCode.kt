package org.honggoii.bookcheck.data

import com.squareup.moshi.JsonClass

/**
 * kdcCode1s - kdcName1s
 * 0 - 총류
 * 1 - 철학
 * 2 - 종교
 * 3 - 사회과학
 * 4 - 순수과학
 * 5 - 기술과학
 * 6 - 에술
 * 7 - 언어
 * 8 - 문학
 * 9 - 역사
 */
@JsonClass(generateAdapter = true)
data class BookCode(
    // 국립 중앙 도서관 검색 API
    val titleInfo: String, // 책 제목
    val authorInfo: String, // 작가
    val pubInfo: String, // 출판사
    val pubYearInfo: String, // 발행년도 사항
    val isbn: String, // isbn
    val kdcCode1s: String, // 대분류 코드
    val kdcName1s: String, // 대분류 명칭
)
