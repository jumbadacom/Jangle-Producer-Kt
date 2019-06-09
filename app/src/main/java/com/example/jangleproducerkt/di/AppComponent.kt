package com.example.jangleproducerkt.di

import com.example.jangleproducerkt.JangleProApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class])
interface AppComponent : AndroidInjector<JangleProApp> {

    @Component.Builder
    abstract class Builder  : AndroidInjector.Builder<JangleProApp>()
}