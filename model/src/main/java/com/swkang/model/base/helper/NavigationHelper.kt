package com.swkang.model.base.helper

import com.swkang.model.domain.restingplaces.repository.dto.RestingPlace

/**
 * @author kangsungwoo
 * @since 5/18/2020
 */
interface NavigationHelper {

    fun popBackStack()

    fun openDetailRestingPlacePage(place: RestingPlace)

}