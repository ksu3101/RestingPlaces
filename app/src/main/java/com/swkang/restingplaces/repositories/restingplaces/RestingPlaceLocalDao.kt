package com.swkang.restingplaces.repositories.restingplaces

import androidx.room.*
import com.swkang.common.DB_FAV_RESTING_PLACES_TBNAME
import com.swkang.model.domain.restingplaces.repository.dto.RestingPlace
import io.reactivex.Completable
import io.reactivex.Single

/**
 * @author kangsungwoo
 * @since 5/18/2020
 */
@Database(entities = arrayOf(RestingPlace::class), version = 1)
abstract class FavRestingPlaceDatabase : RoomDatabase() {
    abstract fun favRestingPlaceDao(): RestingPlaceLocalDao
}

/**
 * 즐겨찾기 최근등록순, 평점순 정렬 기능 구현 (오름차순, 내림차순)
 */
@Dao
abstract class RestingPlaceLocalDao {

    @Query(value = "SELECT * FROM $DB_FAV_RESTING_PLACES_TBNAME ORDER BY created_at ASC")
    abstract fun retrieveFavoriteRestingPlacesByAddedTimeAsc(): Single<List<RestingPlace>>

    @Query(value = "SELECT * FROM $DB_FAV_RESTING_PLACES_TBNAME ORDER BY created_at DESC")
    abstract fun retrieveFavoriteRestingPlacesByAddedTimeDesc(): Single<List<RestingPlace>>

    @Query(value = "SELECT * FROM $DB_FAV_RESTING_PLACES_TBNAME ORDER BY rate ASC")
    abstract fun retrieveFavoriteRestingPlacesByUserRateAsc(): Single<List<RestingPlace>>

    @Query(value = "SELECT * FROM $DB_FAV_RESTING_PLACES_TBNAME ORDER BY rate DESC")
    abstract fun retrieveFavoriteRestingPlacesByUserRateDesc(): Single<List<RestingPlace>>

    @Query(value = "SELECT COUNT(id) FROM $DB_FAV_RESTING_PLACES_TBNAME WHERE id = :id")
    abstract fun countRestingPlaceItemsByUniqueId(id: Long): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun addFavoriteRestingPlace(target: RestingPlace): Completable

    private fun addFavoriteRestingPlaceWithTimeStamp(target: RestingPlace): Completable {
        return addFavoriteRestingPlace(target.apply {
            createdAt = System.currentTimeMillis()
        })
    }

    @Delete
    abstract fun deleteFavoriteRestingPlace(target: RestingPlace): Completable

    fun toggleFavoriteRestingPlace(target: RestingPlace): Completable {
        val countOfFilteredById = countRestingPlaceItemsByUniqueId(target.id)
        return if (countOfFilteredById == 0) {
            addFavoriteRestingPlaceWithTimeStamp(target)
        } else {
            deleteFavoriteRestingPlace(target)
        }
    }

}