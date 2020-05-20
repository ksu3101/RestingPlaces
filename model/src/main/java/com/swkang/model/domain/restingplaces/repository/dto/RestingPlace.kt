package com.swkang.model.domain.restingplaces.repository.dto

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.swkang.common.DB_FAV_RESTING_PLACES_TBNAME

@Entity(tableName = DB_FAV_RESTING_PLACES_TBNAME)
data class RestingPlace(
    @PrimaryKey val id: Long,
    @ColumnInfo val name: String,
    @ColumnInfo val thumbnail: String,
    @ColumnInfo val rate: Double,
    @Embedded val description: RestingPlaceDesc,
    @ColumnInfo(name = "created_at", defaultValue = "0") var createdAt: Long
)