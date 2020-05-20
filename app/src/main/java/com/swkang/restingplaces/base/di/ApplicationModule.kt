package com.swkang.restingplaces.base.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author kangsungwoo
 * @since 5/16/2020
 */

@Module
class ApplicationModule(
    private val application: Application
) {
    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return application
    }

}