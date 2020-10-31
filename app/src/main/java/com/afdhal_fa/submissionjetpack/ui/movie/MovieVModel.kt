package com.afdhal_fa.submissionjetpack.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.afdhal_fa.submissionjetpack.data.source.MovieRepository
import com.afdhal_fa.submissionjetpack.domain.model.Movie
import com.dicoding.academies.vo.Resource

class MovieVModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getMovies(): LiveData<Resource<List<Movie>>> = movieRepository.getAllMovie()

    fun getMoviesFavorite(): LiveData<List<Movie>> = movieRepository.getMovieFavorite()
}