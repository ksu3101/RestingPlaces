package com.swkang.model.domain.restingplaces.repository.dto

import androidx.room.ColumnInfo

data class RestingPlaceDesc(
    @ColumnInfo(name = "image_path") val imagePath: String,
    @ColumnInfo val subject: String,
    @ColumnInfo val price: Long
)