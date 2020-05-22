package com.swkang.restingplaces.view.restingplaces

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.swkang.model.base.BaseViewModel
import com.swkang.model.domain.restingplaces.RestingPlacesViewModel
import com.swkang.restingplaces.R
import com.swkang.restingplaces.base.BaseFragment
import javax.inject.Inject

/**
 * 아이템의 목록을 보여주는 Fragment.
 *
 * @author kangsungwoo
 * @since 5/17/2020
 */
class RestingPlacesFragment : BaseFragment() {

    companion object {
        fun newInstance(): RestingPlacesFragment = RestingPlacesFragment()
    }

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private val vm: RestingPlacesViewModel by viewModels { vmFactory }

    override fun getLayoutId(): Int = R.layout.restingplaces_frag

    override fun createViewModel(): BaseViewModel? = vm

}