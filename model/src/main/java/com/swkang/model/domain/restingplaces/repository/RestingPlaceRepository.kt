package com.swkang.model.domain.restingplaces.repository

import com.swkang.model.domain.restingplaces.repository.dto.RestingPlace
import com.swkang.model.domain.restingplaces.repository.dto.RestingPlaces
import io.reactivex.Completable
import io.reactivex.Single

/**
 * @author kangsungwoo
 * @since 5/18/2020
 */
interface RestingPlaceRepository {

    /**
     * 쉼터 목록을 페이지 단위로 가져온다. 쉼터 갯수는 페이지 당 최대 20개씩 가져온다.
     */
    fun retrieveRestingPlace(page: Int): Single<RestingPlaces>

    /**
     * 즐겨찾기 설정한 쉼터 목록을 등록시간 기준 오름차순으로 모두 가져온다.
     */
    fun retrieveFavoriteRestingPlacesByAddedTimeAsc(): Single<List<RestingPlace>>

    /**
     * 즐겨찾기 설정한 쉼터 목록을 등록시간 기준 내림차순으로 모두 가져온다.
     */
    fun retrieveFavoriteRestingPlacesByAddedTimeDesc(): Single<List<RestingPlace>>

    /**
     * 즐겨찾기 설정한 쉼터 목록을 평점기준 오름차순으로 모두 가져온다.
     */
    fun retrieveFavoriteRestingPlacesByUserRateAsc(): Single<List<RestingPlace>>

    /**
     * 즐겨찾기 설정한 쉼터 목록을 평점기준 내림차순으로 모두 가져온다.
     */
    fun retrieveFavoriteRestingPlacesByUserRateDesc(): Single<List<RestingPlace>>

    /**
     * 쉼터를 즐겿자기 토글 처리 한다.
     */
    fun toggleFavoriteRestingPlace(target: RestingPlace): Completable

}