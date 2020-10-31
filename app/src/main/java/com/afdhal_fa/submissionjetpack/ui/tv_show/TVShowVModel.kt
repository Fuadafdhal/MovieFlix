package com.afdhal_fa.submissionjetpack.ui.tv_show

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.afdhal_fa.submissionjetpack.data.source.MovieRepository
import com.afdhal_fa.submissionjetpack.domain.model.Movie
import com.dicoding.academies.vo.Resource

class TVShowVModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getTVShow(): LiveData<Resource<PagedList<Movie>>> = movieRepository.getAllTVShow()

    fun getTVShowFavorite(): LiveData<PagedList<Movie>> = movieRepository.getTVShowFavorite()
}