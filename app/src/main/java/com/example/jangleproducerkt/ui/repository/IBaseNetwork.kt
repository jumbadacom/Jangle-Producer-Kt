package com.example.jangleproducerkt.ui.repository


import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import com.example.jangleproducerkt.service.ApiResponse

interface IBaseNetwork<NetworkType> {

    @MainThread
    fun createCall(): LiveData<ApiResponse<NetworkType>>

}
