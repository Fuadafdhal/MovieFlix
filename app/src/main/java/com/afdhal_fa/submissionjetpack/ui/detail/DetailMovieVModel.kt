package com.afdhal_fa.submissionjetpack.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.afdhal_fa.submissionjetpack.data.source.MovieRepository
import com.afdhal_fa.submissionjetpack.data.source.local.entity.MovieEntity

class DetailMovieVModel(private val movieRepository: MovieRepository) : ViewModel() {

    private lateinit var movieId: String
    private lateinit var type: String

    fun setSelectedMovie(movieId: String, type: String) {
        this.movieId = movieId
        this.type = type
    }

    fun getMovie(): LiveData<MovieEntity> =
        if (type == "movies") movieRepository.getMovieByID(movieId) else movieRepository.getTVShowByID(movieId)
}