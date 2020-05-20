package com.swkang.model.domain.restingplaces

import com.swkang.model.base.helper.MessageHelper
import com.swkang.model.domain.restingplaces.repository.RestingPlaceRepository

/**
 * @author kangsungwoo
 * @since 5/18/2020
 */
class FavRestingPlacesViewModel(
    repo: RestingPlaceRepository,
    messageHelper: MessageHelper
) : RestingPlacesViewModel(repo, messageHelper) {
    //, messageHelper) {

    private fun retrieveFavRestingPlaces() {

    }

}