package com.swkang.model.domain.restingplaces.repository.dto

data class RestingPlaces(
    val totalCount: Long,
    val product: List<RestingPlace>
)