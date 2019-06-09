package com.example.jangleproducerkt.di

import android.content.Context
import com.example.jangleproducerkt.JangleProApp
import dagger.Binds
import dagger.Module

@Module(includes = [ActivityModule::class, UtilModule::class, ViewModelModule::class, NetworkModule::class])
abstract class AppModule {

    @Binds
    abstract fun provideContext(jangleProApp: JangleProApp): Context
}