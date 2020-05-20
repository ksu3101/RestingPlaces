package com.swkang.model.base.helper

import androidx.annotation.StringRes
import io.reactivex.Completable
import io.reactivex.Single

/**
 * @author kangsungwoo
 * @since 5/16/2020
 */
interface MessageHelper {

    fun showGeneralToast(
        @StringRes messageResId: Int
    )

    fun showErrorToast(
        errorMsgStr: String
    )

    fun showErrorToast(
        @StringRes errorMsgResId: Int,
        errorMsgStr: String? = null
    )

    fun createConfirmDialog(
        @StringRes messageResId: Int = 0
    ): Single<Boolean>

    fun createAlertDialog(
        @StringRes messageResId: Int = 0
    ): Single<Boolean>

    fun createLoadingDialog(): Completable

}