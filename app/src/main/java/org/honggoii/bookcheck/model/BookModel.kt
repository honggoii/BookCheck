package org.honggoii.bookcheck.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookModel(
    // 네이버 도서 검색 API
    val title: String, // 검색 결과 책 제목
    val link: String, // 검색 결과 책의 하이퍼텍스트
    val image: String, // 썸네일 이미지의 URL
    val author: String, // 저자
    val publisher: String, // 출판사
    val pubdate: String, // 출간일
    val isbn: String, // ISBN 넘버
    val description: String, // 검색 결과 책 내용 요약

    // 국립 중앙도서관 API
//    val titleInfo: String, // 표제 리스트
//    val authorInfo: String, // 저작자
//    val pubInfo: String, // 발행자
//    val isbn: String, // ISBN
//    val callNo: String, // 청구기호
//    val kdcCode1s: String, // 동양서분류기호 대분류 코드
//    val kdcName1s: String, // 동양서분류기호 대분류 명칭
//    val classNo: String, // 청구기호
)
