package com.afdhal_fa.submissionjetpack.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntity(
    var id: String? = "",
    var title: String? = "",
    var overview: String? = "",
    var poster: String? = "",
    var language: String? = "",
    var runtime: String? = "",
    var gendre: String? = "",
) : Parcelable