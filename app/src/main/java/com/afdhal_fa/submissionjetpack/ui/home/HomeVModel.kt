package com.afdhal_fa.submissionjetpack.ui.home

import androidx.lifecycle.ViewModel
import com.afdhal_fa.submissionjetpack.model.MovieEntity
import com.afdhal_fa.submissionjetpack.utils.DataDummy

class HomeVModel : ViewModel() {
    fun getMovies(): List<MovieEntity> = DataDummy.generateDummyMovie()
    fun getTVShow(): List<MovieEntity> = DataDummy.generateDummyTVShow()
}