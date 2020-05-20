package com.swkang.restingplaces.repositories.restingplaces

import com.swkang.model.domain.restingplaces.repository.RestingPlaceRepository
import com.swkang.model.domain.restingplaces.repository.dto.RestingPlace
import com.swkang.model.domain.restingplaces.repository.dto.RestingPlaces
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

/**
 * @author kangsungwoo
 * @since 5/18/2020
 */
class RestingPlaceRepositoryImpl @Inject constructor(
    private val localRepo: RestingPlaceLocalDao,
    private val remoteRepo: RestingPlaceRemoteDataSource
) : RestingPlaceRepository {

    override fun retrieveRestingPlace(page: Int): Single<RestingPlaces> {
        return remoteRepo.retrieveRestingPlace(page)
    }

    override fun retrieveFavoriteRestingPlacesByAddedTimeAsc(): Single<List<RestingPlace>> {
        return localRepo.retrieveFavoriteRestingPlacesByAddedTimeAsc()
    }

    override fun retrieveFavoriteRestingPlacesByAddedTimeDesc(): Single<List<RestingPlace>> {
        return localRepo.retrieveFavoriteRestingPlacesByAddedTimeDesc()
    }

    override fun retrieveFavoriteRestingPlacesByUserRateAsc(): Single<List<RestingPlace>> {
        return localRepo.retrieveFavoriteRestingPlacesByUserRateAsc()
    }

    override fun retrieveFavoriteRestingPlacesByUserRateDesc(): Single<List<RestingPlace>> {
        return localRepo.retrieveFavoriteRestingPlacesByUserRateDesc()
    }

    override fun toggleFavoriteRestingPlace(target: RestingPlace): Completable {
        return localRepo.toggleFavoriteRestingPlace(target)
    }

}