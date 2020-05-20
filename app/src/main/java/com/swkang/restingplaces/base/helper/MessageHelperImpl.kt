package com.swkang.restingplaces.base.helper

import android.content.Context
import com.swkang.model.base.helper.MessageHelper
import io.reactivex.Completable
import io.reactivex.Single

/**
 * @author kangsungwoo
 * @since 5/19/2020
 */
class MessageHelperImpl(
    val context: Context
):MessageHelper {
    override fun showGeneralToast(messageResId: Int) {
    }

    override fun showErrorToast(errorMsgStr: String) {
    }

    override fun showErrorToast(errorMsgResId: Int, errorMsgStr: String?) {
    }

    override fun createConfirmDialog(messageResId: Int): Single<Boolean> {
        return Single.just(true)
    }

    override fun createAlertDialog(messageResId: Int): Single<Boolean> {
        return Single.just(true)
    }

    override fun createLoadingDialog(): Completable {
        return Completable.complete()
    }
}