package com.swkang.restingplaces.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.swkang.model.base.BaseViewModel
import com.swkang.model.base.redux.State
import dagger.android.support.DaggerFragment
import io.reactivex.disposables.CompositeDisposable

/**
 * @author kangsungwoo
 * @since 5/16/2020
 */
abstract class BaseFragment<S: State> : DaggerFragment() {
    private lateinit var binding: ViewDataBinding
    private var viewModel: BaseViewModel<S>? = null
    private val compositeDisposable = CompositeDisposable()

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun createViewModel(): BaseViewModel<S>?

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        compositeDisposable.clear()
        compositeDisposable.add(

        )

        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        //binding.setVariable(BR.vm, viewModel)
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel = createViewModel()

        return binding.root
    }

    override fun onDestroyView() {
        compositeDisposable.dispose()
        if (viewModel != null) {
            viewModel!!.dispose()
        }
        super.onDestroyView()
    }

}