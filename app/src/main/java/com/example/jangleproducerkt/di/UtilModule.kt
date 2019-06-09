package com.example.jangleproducerkt.di

import android.content.Context
import com.example.jangleproducerkt.service.util.NetworkError
import com.example.jangleproducerkt.util.TestObj
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class UtilModule {

    @Provides
    @Singleton
    fun provideTestObj(context: Context): TestObj {
        return TestObj(context)
    }



    @Provides
    @Singleton
    fun provideNetworkError(gson: Gson): NetworkError {
        return NetworkError(gson)
    }

}