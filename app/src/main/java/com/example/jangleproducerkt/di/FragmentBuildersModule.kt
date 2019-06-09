package com.example.jangleproducerkt.di

import com.example.jangleproducerkt.ui.view.fragments.CreateUserFragment
import com.example.jangleproducerkt.ui.view.fragments.NavFragment
import com.example.jangleproducerkt.ui.view.fragments.ProfileFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeNavFragment(): NavFragment

    @ContributesAndroidInjector
    abstract fun contributeCreateUserFragment(): CreateUserFragment

    @ContributesAndroidInjector
    abstract fun contributeProfileFragment(): ProfileFragment


}