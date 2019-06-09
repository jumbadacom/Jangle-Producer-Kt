package com.example.jangleproducerkt


import com.example.jangleproducerkt.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class JangleProApp : DaggerApplication() {

    @SuppressWarnings("unchecked")
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }


}