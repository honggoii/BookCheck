package org.honggoii.bookcheck.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResponse(
    var kwd: String, // 검색어
    var category:String, // 카테고리
    var pageNum:String, // 현재페이지
    var pageSize:Int, // 쪽당출력건수 (기본 10건)
    var sort:String, // 정렬
    var total:Int,  // 검색건수
    val result:List<BookModel>?,
)
