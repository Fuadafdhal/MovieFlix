package com.afdhal_fa.submissionjetpack.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: String,
    val title: String,
    val overview: String,
    val poster: String,
    val language: String,
    val runtime: String,
    val gendre: String,
    var favorite: Boolean
) : Parcelable