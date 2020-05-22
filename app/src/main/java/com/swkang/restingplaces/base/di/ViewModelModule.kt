package com.swkang.restingplaces.base.di

import androidx.lifecycle.ViewModelProvider
import com.swkang.restingplaces.base.ViewModelFactory
import dagger.Binds
import dagger.Module

/**
 * @author kangsungwoo
 * @since 5/16/2020
 */
@Module
abstract class ViewModelBuilder {
    @Binds
    abstract fun viewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}