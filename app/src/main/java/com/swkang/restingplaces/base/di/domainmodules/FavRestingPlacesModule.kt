package com.swkang.restingplaces.base.di.domainmodules

import androidx.lifecycle.ViewModel
import com.swkang.model.domain.restingplaces.FavRestingPlacesViewModel
import com.swkang.restingplaces.base.ViewModelKey
import com.swkang.restingplaces.base.di.ViewModelBuilder
import com.swkang.restingplaces.view.restingplaces.FavRestingPlacesFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * @author kangsungwoo
 * @since 5/22/2020
 */
@Module
abstract class FavRestingPlacesModule {

    @ContributesAndroidInjector(modules = [ViewModelBuilder::class])
    abstract fun favRestingPlacesFragment(): FavRestingPlacesFragment

    @Binds
    @IntoMap
    @ViewModelKey(FavRestingPlacesViewModel::class)
    abstract fun bindFavRestingPlacesViewModel(vm: FavRestingPlacesViewModel): ViewModel

}