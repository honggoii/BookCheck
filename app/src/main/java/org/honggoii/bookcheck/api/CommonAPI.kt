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
import retrofit2.http.*
import java.net.URLDecoder

interface CommonAPI {

    /**
     *
     */
    @GET("search.do")
    fun getSearch (
        @Query("key") serviceKey: String = BuildConfig.SEARCH_API_KEY,
        @Query("pageNum") pageNum: Int = 1,
        @Query("pageSize") pageSize: Int = 10,
        @Query("kwd") kwd: String = URLDecoder.decode("토지", "UTF-8"),
        @Query("apiType") apiType: String = "json",
    ) : Call<SearchResponse>

    companion object {
        private const val BASE_URL = "https://www.nl.go.kr/NL/search/openApi/"

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