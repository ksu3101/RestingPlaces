package com.swkang.restingplaces.base.di.domainmodules

import androidx.lifecycle.ViewModel
import com.swkang.model.domain.restingplaces.RestingPlacesViewModel
import com.swkang.restingplaces.base.ViewModelKey
import com.swkang.restingplaces.base.di.ViewModelBuilder
import com.swkang.restingplaces.view.restingplaces.RestingPlacesFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * @author kangsungwoo
 * @since 5/22/2020
 */
@Module
abstract class RestingPlacesModule {

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    abstract fun restingPlacesFragment(): RestingPlacesFragment

    @Binds
    @IntoMap
    @ViewModelKey(RestingPlacesViewModel::class)
    abstract fun bindRestingPlacesViewModel(vm: RestingPlacesViewModel): ViewModel

}