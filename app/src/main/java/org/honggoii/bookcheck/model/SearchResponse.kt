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

    // 국립 중앙도서관 API
//    var kwd: String, // 검색어
//    var category:String, // 카테고리
//    var pageNum:String, // 현재페이지
//    var pageSize:Int, // 쪽당출력건수 (기본 10건)
//    var sort:String, // 정렬
//    var total:Int,  // 검색건수
//    val result:List<BookModel>?,
)
