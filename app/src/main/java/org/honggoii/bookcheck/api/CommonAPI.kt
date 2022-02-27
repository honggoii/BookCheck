package org.honggoii.bookcheck.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.honggoii.bookcheck.BuildConfig
import org.honggoii.bookcheck.model.SearchResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * 네이버 도서 검색 API 사용
 */
interface CommonAPI {
    @GET("book")
    fun getSearch (
        @Header("X-Naver-Client-Id") id: String = BuildConfig.SEARCH_API_CLIENT_ID,
        @Header("X-Naver-Client-Secret") pw: String = BuildConfig.SEARCH_API_CLIENT_SECRET,
        @Query("query") query: String,
        @Query("start") start: Int,
        @Query("display") display: Int = 20,
    ) : Call<SearchResponse>

    companion object {
        private const val BASE_URL = "https://openapi.naver.com/v1/search/"

        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
                .build()
        }
    }