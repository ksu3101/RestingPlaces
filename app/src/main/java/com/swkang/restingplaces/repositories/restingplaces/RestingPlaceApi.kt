package com.swkang.restingplaces.repositories.restingplaces

import com.swkang.model.domain.restingplaces.repository.dto.RestingPlaces
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author kangsungwoo
 * @since 5/18/2020
 */
interface RestingPlaceApi {

    @GET("{page}.json")
    fun retrieveRestingPlace(
        @Path("page") page: Int
    ): Single<RestingPlaces>

}