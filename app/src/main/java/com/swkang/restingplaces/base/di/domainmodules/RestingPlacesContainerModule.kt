package com.swkang.restingplaces.base.di.domainmodules

import androidx.lifecycle.ViewModel
import com.swkang.model.domain.restingplaces.RestingPlacesContainerViewModel
import com.swkang.restingplaces.base.ViewModelKey
import com.swkang.restingplaces.base.di.ViewModelBuilder
import com.swkang.restingplaces.view.restingplaces.RestingPlacesContainerFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * @author kangsungwoo
 * @since 5/22/2020
 */
@Module
abstract class RestingPlacesContainerModule {

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    abstract fun restingPlacesContainerFragment(): RestingPlacesContainerFragment

    @Binds
    @IntoMap
    @ViewModelKey(RestingPlacesContainerViewModel::class)
    abstract fun bindRestingPlacesContainerViewModel(vm: RestingPlacesContainerViewModel): ViewModel

}