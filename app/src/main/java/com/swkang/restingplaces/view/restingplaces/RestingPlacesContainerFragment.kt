package com.swkang.restingplaces.view.restingplaces

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.swkang.model.base.BaseViewModel
import com.swkang.model.domain.restingplaces.restingplaces.RestingPlacesContainerViewModel
import com.swkang.restingplaces.R
import com.swkang.restingplaces.base.BaseFragment
import javax.inject.Inject

/**
 * @author kangsungwoo
 * @since 5/18/2020
 */
class RestingPlacesContainerFragment : BaseFragment() {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private val vm: RestingPlacesContainerViewModel by viewModels { vmFactory }

    override fun getLayoutId(): Int = R.layout.restingplacescontainer_frag

    override fun createViewModel(): BaseViewModel? = vm

}