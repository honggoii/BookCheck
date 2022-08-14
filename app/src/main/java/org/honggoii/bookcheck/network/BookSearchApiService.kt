package org.honggoii.bookcheck.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.honggoii.bookcheck.BuildConfig
import org.honggoii.bookcheck.api.CommonAPI
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

private const val BASE_URL = "https://openapi.naver.com/v1/search/"

/**
 * Moshi object
 * JSON -> Kotlin 객체로 변환
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Retrofit object
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(CommonAPI.moshi).asLenient())
    .baseUrl(BASE_URL)
    .build()

interface BookSearchApiService {
    @GET("book")
    suspend fun getBooks(
        @Header("X-Naver-Client-Id") id: String = BuildConfig.SEARCH_API_CLIENT_ID,
        @Header("X-Naver-Client-Secret") pw: String = BuildConfig.SEARCH_API_CLIENT_SECRET,
        @Query("query") query: String,
        @Query("start") start: Int,
        @Query("display") display: Int = 20,
    ): SearchResponse
}

/**
 * public singleton object
 */
object BookSearchApi {
    val retrofitService : BookSearchApiService by lazy {
        retrofit.create(BookSearchApiService::class.java)
    }
}