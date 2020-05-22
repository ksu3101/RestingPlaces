package com.swkang.restingplaces.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.swkang.model.base.BaseViewModel
import dagger.android.support.DaggerFragment

/**
 * @author kangsungwoo
 * @since 5/16/2020
 */
abstract class BaseFragment : DaggerFragment() {
    private lateinit var binding: ViewDataBinding
    private var viewModel: BaseViewModel? = null

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun createViewModel(): BaseViewModel?

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        //binding.setVariable(BR.vm, viewModel)
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel = createViewModel()

        return binding.root
    }

    override fun onDestroyView() {
        if (viewModel != null) {
            viewModel!!.dispose()
        }
        super.onDestroyView()
    }

}