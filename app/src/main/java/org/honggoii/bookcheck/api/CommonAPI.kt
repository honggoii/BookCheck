package org.honggoii.bookcheck.api

import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface CommonAPI {

    /**
     *
     */
    @GET
    fun getSearchResponse (
        @Url getUrl: String,
        @HeaderMap headerParams: MutableMap<String, String>,
        @QueryMap queryParams: MutableMap<String, Any>
    )
}