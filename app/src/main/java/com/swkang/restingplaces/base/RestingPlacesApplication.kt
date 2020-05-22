package com.swkang.restingplaces.base

import androidx.multidex.MultiDex
import com.swkang.restingplaces.base.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * @author kangsungwoo
 * @since 5/16/2020
 */
class RestingPlacesApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
    }

}