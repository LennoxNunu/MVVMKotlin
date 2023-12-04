package com.example.mvvmkotlin.presentation.di.tvshow

import com.example.mvvmkotlin.presentation.tv.TvShowActivity
import dagger.Subcomponent


@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }

}

