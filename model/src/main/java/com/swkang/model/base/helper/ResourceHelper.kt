package com.swkang.model.base.helper

import androidx.annotation.StringRes

/**
 * @author kangsungwoo
 * @since 5/16/2020
 */
interface ResourceHelper {

    fun getString(@StringRes strResId: Int): String

}