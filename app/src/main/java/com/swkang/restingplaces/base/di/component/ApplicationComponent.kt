package com.swkang.restingplaces.base.di.component

import com.swkang.model.domain.restingplaces.repository.RestingPlaceRepository
import com.swkang.restingplaces.base.ViewModelFactory
import com.swkang.restingplaces.base.di.ApplicationModule
import com.swkang.restingplaces.base.di.NetworkModule
import com.swkang.restingplaces.base.di.ViewModelBuilder
import com.swkang.restingplaces.base.di.ViewModelModule
import com.swkang.restingplaces.base.di.domainmodules.RestingPlaceRepoModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author kangsungwoo
 * @since 5/16/2020
 */
@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NetworkModule::class,
        ViewModelBuilder::class,
        ViewModelModule::class,
        RestingPlaceRepoModule::class
    ]
)
interface ApplicationComponent {

    //fun viewModelFactory(): ViewModelFactory

    fun restingPlaceRespository(): RestingPlaceRepository

}