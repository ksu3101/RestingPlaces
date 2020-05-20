package com.swkang.restingplaces.base.di.component

import com.swkang.model.base.helper.MessageHelper
import com.swkang.restingplaces.base.di.ActivityModule
import com.swkang.restingplaces.base.di.scope.PerActivity
import com.swkang.restingplaces.view.restingplaces.FavRestingPlacesFragment
import com.swkang.restingplaces.view.restingplaces.RestingPlacesContainerFragment
import com.swkang.restingplaces.view.restingplaces.RestingPlacesFragment
import dagger.Component


@PerActivity
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {
    fun messageHelper(): MessageHelper

    fun inject(fragment: RestingPlacesContainerFragment)
    fun inject(fragment: RestingPlacesFragment)
    fun inject(fragment: FavRestingPlacesFragment)
}