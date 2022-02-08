package org.honggoii.bookcheck.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import okhttp3.internal.http2.Http2Reader.Companion.logger
import okhttp3.logging.HttpLoggingInterceptor
import org.honggoii.bookcheck.model.BookModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

interface CommonAPI {
    /**
     *
     */
    @GET
    fun getSearchResponse (
        @Query("key") serviceKey: String = "fa4f7bd188ac2149a1a69bd316f47bd51d27ac7c9b5968f6aad5359ffc6b03b2",
        @Query("pageNum") pageNum: Int = 1,
        @Query("pageSize") pageSize: Int = 10,
        @Query("kwd") kwd: String = "%ED%86%A0%EC%A7%80"
    ) : Call<BookModel>

    companion object {
        private const val BASE_URL = "https://www.nl.go.kr/NL/search/openApi/search.do"

        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        fun create(): CommonAPI {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
                .create(CommonAPI::class.java)
        }
    }

}