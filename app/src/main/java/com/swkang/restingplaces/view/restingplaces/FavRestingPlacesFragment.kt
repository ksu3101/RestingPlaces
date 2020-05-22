package com.swkang.restingplaces.view.restingplaces

import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.swkang.model.base.BaseViewModel
import com.swkang.model.domain.restingplaces.FavRestingPlacesViewModel
import com.swkang.restingplaces.R
import com.swkang.restingplaces.base.BaseFragment
import javax.inject.Inject

/**
 * @author kangsungwoo
 * @since 5/17/2020
 */
class FavRestingPlacesFragment : BaseFragment() {

    companion object {
        fun newInstance(): FavRestingPlacesFragment = FavRestingPlacesFragment()
    }

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    private val vm: FavRestingPlacesViewModel by viewModels { vmFactory }

    override fun getLayoutId(): Int = R.layout.restingplaces_frag

    override fun createViewModel(): BaseViewModel? = vm

}