package org.honggoii.bookcheck

import org.honggoii.bookcheck.api.CommonAPI
import org.honggoii.bookcheck.api.CommonAPI.Companion.retrofit

object BookAPI {
    val retrofitService: CommonAPI by lazy {
        retrofit.create(CommonAPI::class.java)
    }
}