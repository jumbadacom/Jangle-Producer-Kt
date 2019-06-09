package com.example.jangleproducerkt.service.result.error

import com.google.gson.annotations.Expose


data class ErrorResponseModel(
    @Expose
    val type: String,
    @Expose
    val title: String,
    @Expose
    val status: Int,
    @Expose
    val detail: String

)
