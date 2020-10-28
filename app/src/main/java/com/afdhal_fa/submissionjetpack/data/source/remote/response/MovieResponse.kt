package com.afdhal_fa.submissionjetpack.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    val id: String,
    val title: String,
    val overview: String,
    val poster: String,
    val language: String,
    val runtime: String,
    val gendre: String,
) : Parcelable