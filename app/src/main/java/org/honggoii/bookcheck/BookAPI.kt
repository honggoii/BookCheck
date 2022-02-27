package org.honggoii.bookcheck

import org.honggoii.bookcheck.api.CommonAPI
import org.honggoii.bookcheck.api.CommonAPI.Companion.retrofit
import org.honggoii.bookcheck.api.MyBookAPI
import org.honggoii.bookcheck.api.MyBookAPI.Companion.retrofit2

object BookAPI {
    val retrofitService: CommonAPI by lazy {
        retrofit.create(CommonAPI::class.java)
    }
    val retrofitService2: MyBookAPI by lazy {
        retrofit2.create(MyBookAPI::class.java)
    }
}