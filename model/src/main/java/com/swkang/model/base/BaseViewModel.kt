package com.swkang.model.base

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * @author kangsungwoo
 * @since 5/16/2020
 */
abstract class BaseViewModel : ViewModel(), RxDisposer {
    private lateinit var compositeDisposable: CompositeDisposable

    override fun addDisposer(disposable: Disposable) {
        if (!::compositeDisposable.isInitialized) {
            compositeDisposable = CompositeDisposable()
        }
        compositeDisposable.add(disposable)
    }

    override fun dispose() {
        if (::compositeDisposable.isInitialized) {
            compositeDisposable.dispose()
        }
    }
}
