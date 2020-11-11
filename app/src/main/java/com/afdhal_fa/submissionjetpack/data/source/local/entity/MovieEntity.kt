package com.afdhal_fa.submissionjetpack.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey @NonNull @ColumnInfo(name = "id") val id: String,

    @ColumnInfo(name = "title") val title: String,

    @ColumnInfo(name = "overview") val overview: String,

    @ColumnInfo(name = "poster") val poster: String,

    @ColumnInfo(name = "language") val language: String,

    @ColumnInfo(name = "runtime") val runtime: String,

    @ColumnInfo(name = "gendre") val gendre: String,

    @ColumnInfo(name = "favorite") var favorite: Boolean
)