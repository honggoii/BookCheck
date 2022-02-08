package org.honggoii.bookcheck.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookModel(
    var kwd: String, // 검색어
    var category:String, // 카테고리
    var pageNum:String, // 현재페이지
    var pageSize:Int, // 쪽당출력건수 (기본 10건)
    var sort:String, // 정렬
    var total :Int,  // 검색건수
    @SerializedName("title_info") var titleInfo: String, // 표제 리스트
    @SerializedName("type_name") var typeName: String, // 자료유형
    @SerializedName("author_info") var authorInfo: String, // 저작자
    @SerializedName("pub_info") var pubInfo: String, // 발행자
    var isbn: String, // ISBN
    @SerializedName("call_no") var callNo: String, // 청구기호
)
