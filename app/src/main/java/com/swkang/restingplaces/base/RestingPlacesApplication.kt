package com.swkang.restingplaces.base

import androidx.multidex.MultiDexApplication
import com.swkang.restingplaces.base.di.ApplicationModule
import com.swkang.restingplaces.base.di.component.ApplicationComponent
import com.swkang.restingplaces.base.di.component.DaggerApplicationComponent

/**
 * @author kangsungwoo
 * @since 5/16/2020
 */
class RestingPlacesApplication: MultiDexApplication() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

}