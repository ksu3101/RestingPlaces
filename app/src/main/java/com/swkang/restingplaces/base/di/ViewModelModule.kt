package com.swkang.restingplaces.base.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.swkang.model.domain.restingplaces.FavRestingPlacesViewModel
import com.swkang.model.domain.restingplaces.RestingPlacesContainerViewModel
import com.swkang.model.domain.restingplaces.RestingPlacesViewModel
import com.swkang.restingplaces.base.ViewModelFactory
import com.swkang.restingplaces.base.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * @author kangsungwoo
 * @since 5/16/2020
 */
@Module
abstract class ViewModelBuilder {
    @Binds
    abstract fun viewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(RestingPlacesContainerViewModel::class)
    abstract fun bindRestingPlacesContainerViewModel(vm: RestingPlacesContainerViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RestingPlacesViewModel::class)
    abstract fun bindRestingPlacesViewModel(vm: RestingPlacesViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavRestingPlacesViewModel::class)
    abstract fun bindFavRestingPlacesViewModel(vm: FavRestingPlacesViewModel): ViewModel

}