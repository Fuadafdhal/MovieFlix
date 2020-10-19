package com.afdhal_fa.submissionjetpack.ui.home

import android.content.Context
import androidx.lifecycle.ViewModel
import com.afdhal_fa.submissionjetpack.model.MovieEntity
import com.afdhal_fa.submissionjetpack.utils.DataDummy

class HomeVModel : ViewModel() {
    fun getMovies(mContext: Context): List<MovieEntity> = DataDummy.generateDummyMovie(mContext)
    fun getTVShow(mContext: Context): List<MovieEntity> = DataDummy.generateDummyTVShow(mContext)
}