package org.honggoii.bookcheck.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookModel(
    val titleInfo: String, // 표제 리스트
    val authorInfo: String, // 저작자
    val pubInfo: String, // 발행자
    val isbn: String, // ISBN
    val callNo: String, // 청구기호
    val kdcCode1s: String, // 동양서분류기호 대분류 코드
    val kdcName1s: String, // 동양서분류기호 대분류 명칭
    val classNo: String, // 청구기호
)
