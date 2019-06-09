package com.example.jangleproducerkt.util

import android.content.Context
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TestObj @Inject constructor(private val context: Context){

    fun  deneme() : String {
       return context.theme.toString()
    }
}