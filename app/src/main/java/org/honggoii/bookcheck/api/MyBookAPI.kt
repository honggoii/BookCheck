package org.honggoii.bookcheck.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.honggoii.bookcheck.BuildConfig
import org.honggoii.bookcheck.model.MyBookResponse
import org.honggoii.bookcheck.model.SearchResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import java.util.concurrent.TimeUnit

/**
 * 카테고리를 분류하기 위해 국립중앙도서관 API를 호출합니다.
 */
interface MyBookAPI {

    @GET("search.do")
    fun getMyBook (
        @Query("key") certKey: String = BuildConfig.SEARCH_API_KEY,
        @Query("detailSearch") detailSearch: String = "true",
        @Query("isbnOp") isbnOp: String = "isbn",
        @Query("isbn") isbn: String,
        @Query("apiType") apiType: String = "json",
    ) : Call<MyBookResponse>

    companion object {
        private const val BASE_URL = "https://www.nl.go.kr/NL/search/openApi/"

        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100,TimeUnit.SECONDS)
            .writeTimeout(100,TimeUnit.SECONDS)
            .build()

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit2 = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
                .build()
        }
    }