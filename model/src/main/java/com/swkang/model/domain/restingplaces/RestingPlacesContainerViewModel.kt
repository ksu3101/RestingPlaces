package com.swkang.model.domain.restingplaces

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.swkang.model.base.BaseViewModel
import com.swkang.model.base.helper.MessageHelper
import com.swkang.model.domain.restingplaces.repository.RestingPlaceRepository
import javax.inject.Inject

/**
 * @author kangsungwoo
 * @since 5/18/2020
 */
class RestingPlacesContainerViewModel @Inject constructor(
    repo: RestingPlaceRepository,
    messageHelper: MessageHelper
) : BaseViewModel() {

    private val _pagerItemViewModels: MutableLiveData<List<ViewModel>> = MutableLiveData(
        listOf(
            RestingPlacesViewModel(repo, messageHelper),//, messageHelper),
            FavRestingPlacesViewModel(repo, messageHelper)//, messageHelper)
        )
    )
    val pagerItemViewModels: LiveData<List<ViewModel>>
        get() = _pagerItemViewModels

}