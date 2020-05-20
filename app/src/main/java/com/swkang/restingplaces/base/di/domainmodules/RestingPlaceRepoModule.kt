package com.swkang.restingplaces.base.di.domainmodules

import android.content.Context
import androidx.room.Room
import com.swkang.model.domain.restingplaces.repository.RestingPlaceRepository
import com.swkang.restingplaces.repositories.restingplaces.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author kangsungwoo
 * @since 5/18/2020
 */
@Module
class RestingPlaceRepoModule {

    @Provides
    @Singleton
    fun provideRestingPlaceLocalDao(context: Context): RestingPlaceLocalDao {
        val db = Room.databaseBuilder(
            context,
            FavRestingPlaceDatabase::class.java,
            "restingplace.db"
        ).build()
        return db.favRestingPlaceDao()
    }

    @Provides
    @Singleton
    fun provideRestingPlaceRemoteDataSource(api: RestingPlaceApi): RestingPlaceRemoteDataSource {
        return RestingPlaceRemoteDataSource(api)
    }

    @Provides
    @Singleton
    fun provideRestingPlaceRepository(
        localDao: RestingPlaceLocalDao,
        remoteDataSource: RestingPlaceRemoteDataSource
    ): RestingPlaceRepository {
        return RestingPlaceRepositoryImpl(localDao, remoteDataSource)
    }

}