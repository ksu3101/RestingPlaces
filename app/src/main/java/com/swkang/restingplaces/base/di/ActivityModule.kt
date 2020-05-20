package com.swkang.restingplaces.base.di

import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.swkang.model.base.helper.MessageHelper
import com.swkang.restingplaces.base.di.scope.PerActivity
import com.swkang.restingplaces.base.helper.MessageHelperImpl
import dagger.Module
import dagger.Provides

/**
 * @author kangsungwoo
 * @since 5/18/2020
 */
@Module
class ActivityModule(
    private val activity: FragmentActivity
) {

    @Provides
    @PerActivity
    fun provideMessageHelper(): MessageHelper {
        return MessageHelperImpl(activity)
    }

    @Provides
    @PerActivity
    fun provideActivity(): FragmentActivity {
        return this.activity
    }

    @Provides
    @PerActivity
    fun provideFragmentManager(): FragmentManager {
        return activity.supportFragmentManager
    }

}