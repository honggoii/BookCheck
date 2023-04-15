package org.honggoii.bookcheck.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.honggoii.bookcheck.BuildConfig
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

private const val NAVER_BASE_URL = "https://openapi.naver.com/v1/search/"
private const val NL_BASE_URL = "https://www.nl.go.kr/NL/search/openApi/"

private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
private val client = OkHttpClient
    .Builder()
    .addInterceptor(interceptor)
    .build()

/**
 * Moshi object
 * JSON -> Kotlin 객체로 변환
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Retrofit object: 네이버 도서 검색
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
    .baseUrl(NAVER_BASE_URL)
    .client(client)
    .build()

/**
 * Retrofit object: 국립 중앙 도서관 도서 검색
 */
private val retrofit2 = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
    .baseUrl(NL_BASE_URL)
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

    @GET("search.do")
    suspend fun getBookCode (
        @Query("key") certKey: String = BuildConfig.SEARCH_API_KEY,
        @Query("detailSearch") detailSearch: String = "true",
        @Query("isbnOp") isbnOp: String = "isbn",
        @Query("isbnCode") isbn: String,
        @Query("apiType") apiType: String = "json",
    ) : BookIsbnResponse
}

/**
 * public singleton object
 */
object BookSearchApi {
    val retrofitService : BookSearchApiService by lazy {
        retrofit.create(BookSearchApiService::class.java)
    }

    val retrofitService2: BookSearchApiService by lazy {
        retrofit2.create(BookSearchApiService::class.java)
    }
}