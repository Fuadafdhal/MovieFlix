package com.afdhal_fa.submissionjetpack.data.source

import androidx.lifecycle.LiveData
import com.afdhal_fa.submissionjetpack.data.source.local.entity.MovieEntity
import com.afdhal_fa.submissionjetpack.data.source.local.entity.TVShowEntity
import com.afdhal_fa.submissionjetpack.domain.model.Movie
import com.dicoding.academies.vo.Resource

interface MovieDataResource {
    fun getAllMovie(): LiveData<Resource<List<Movie>>>

    fun getMovieByID(movieID: String): LiveData<Movie>

    fun getAllTVShow(): LiveData<Resource<List<Movie>>>

    fun getTVShowByID(tvshowID: String): LiveData<Movie>

    fun getMovieFavorite(): LiveData<List<Movie>>

    fun getTVShowFavorite(): LiveData<List<Movie>>

    fun setFavoriteMovie(movieEntity: MovieEntity, states: Boolean)

    fun setFavoriteTVShow(tvShowEntity: TVShowEntity, states: Boolean)
}