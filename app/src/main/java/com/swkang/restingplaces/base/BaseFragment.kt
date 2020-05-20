package com.swkang.restingplaces.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.swkang.model.base.BaseViewModel
import com.swkang.restingplaces.base.di.ActivityModule
import com.swkang.restingplaces.base.di.component.ActivityComponent
import com.swkang.restingplaces.base.di.component.DaggerActivityComponent

/**
 * @author kangsungwoo
 * @since 5/16/2020
 */
abstract class BaseFragment : Fragment() {
    private lateinit var binding: ViewDataBinding
    private lateinit var activityComponent: ActivityComponent
    private var viewModel: BaseViewModel? = null

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun createViewModel(): BaseViewModel?

    abstract fun onInject(activityComponent: ActivityComponent)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = activity?.application as RestingPlacesApplication
        activityComponent = DaggerActivityComponent.builder()
            .applicationComponent(application.applicationComponent)
            .activityModule(ActivityModule(requireActivity()))
            .build()

        onInject(activityComponent)

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