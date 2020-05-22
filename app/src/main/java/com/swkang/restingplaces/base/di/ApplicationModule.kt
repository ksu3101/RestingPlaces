package com.swkang.restingplaces.base.di

import android.content.Context
import com.swkang.model.base.helper.MessageHelper
import com.swkang.restingplaces.base.helper.MessageHelperImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author kangsungwoo
 * @since 5/16/2020
 */
@Module
object ApplicationModule {

    @Singleton
    @Provides
    fun provideMessageHelper(context: Context): MessageHelper {
        return MessageHelperImpl(context)
    }

}