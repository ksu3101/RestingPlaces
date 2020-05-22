package com.swkang.restingplaces.base.di

import android.content.Context
import com.swkang.model.base.helper.MessageHelper
import com.swkang.model.domain.restingplaces.repository.RestingPlaceRepository
import com.swkang.restingplaces.base.RestingPlacesApplication
import com.swkang.restingplaces.base.di.domainmodules.FavRestingPlacesModule
import com.swkang.restingplaces.base.di.domainmodules.RestingPlaceRepoModule
import com.swkang.restingplaces.base.di.domainmodules.RestingPlacesContainerModule
import com.swkang.restingplaces.base.di.domainmodules.RestingPlacesModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * @author kangsungwoo
 * @since 5/16/2020
 */
@Singleton
@Component(
    modules = [
        // common modules
        ApplicationModule::class,
        AndroidSupportInjectionModule::class,
        NetworkModule::class,

        // Domain modules
        RestingPlaceRepoModule::class,
        RestingPlacesContainerModule::class,
        RestingPlacesModule::class,
        FavRestingPlacesModule::class
    ]
)
interface ApplicationComponent: AndroidInjector<RestingPlacesApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

    fun messageHelper(): MessageHelper

    fun restingPlaceRespository(): RestingPlaceRepository

}