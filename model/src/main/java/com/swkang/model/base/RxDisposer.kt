package com.swkang.model.base

import io.reactivex.disposables.Disposable

/**
 * @author kangsungwoo
 * @since 5/16/2020
 */
interface RxDisposer {
    fun addDisposer(disposable: Disposable)

    fun dispose()
}