package com.swkang.restingplaces.repositories.restingplaces

import com.swkang.model.domain.restingplaces.repository.dto.RestingPlaces
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @author kangsungwoo
 * @since 5/18/2020
 */
class RestingPlaceRemoteDataSource @Inject constructor(
    val api: RestingPlaceApi
) {

    fun retrieveRestingPlace(page: Int): Single<RestingPlaces> {
        return api.retrieveRestingPlace(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}