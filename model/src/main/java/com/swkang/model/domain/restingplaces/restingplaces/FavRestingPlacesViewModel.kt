package com.swkang.model.domain.restingplaces.restingplaces

import com.swkang.model.base.helper.MessageHelper
import com.swkang.model.domain.restingplaces.RestingPlacesViewModel
import com.swkang.model.domain.restingplaces.repository.RestingPlaceRepository
import javax.inject.Inject

/**
 * @author kangsungwoo
 * @since 5/18/2020
 */
class FavRestingPlacesViewModel @Inject constructor(
    repo: RestingPlaceRepository,
    messageHelper: MessageHelper
) : RestingPlacesViewModel(repo, messageHelper) {

    private fun retrieveFavRestingPlaces() {

    }

}