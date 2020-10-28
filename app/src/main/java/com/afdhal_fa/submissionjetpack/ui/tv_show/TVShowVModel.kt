package com.afdhal_fa.submissionjetpack.ui.tv_show

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.afdhal_fa.submissionjetpack.data.source.MovieRepository
import com.afdhal_fa.submissionjetpack.data.source.local.entity.MovieEntity

class TVShowVModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getTVShow(): LiveData<List<MovieEntity>> = movieRepository.getAllTVShow()
}