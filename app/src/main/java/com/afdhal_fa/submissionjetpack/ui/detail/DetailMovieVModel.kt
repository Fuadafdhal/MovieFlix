package com.afdhal_fa.submissionjetpack.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.afdhal_fa.submissionjetpack.data.source.MovieRepository
import com.afdhal_fa.submissionjetpack.data.source.local.entity.MovieEntity
import com.afdhal_fa.submissionjetpack.data.source.local.entity.TVShowEntity
import com.afdhal_fa.submissionjetpack.domain.model.Movie

class DetailMovieVModel(private val movieRepository: MovieRepository) : ViewModel() {

    private lateinit var movieId: String
    private lateinit var type: String

    fun setSelectedMovie(movieId: String, type: String) {
        this.movieId = movieId
        this.type = type
    }

    fun getMovie(): LiveData<Movie> = if (type == "movies") movieRepository.getMovieByID(movieId) else movieRepository.getTVShowByID(movieId)

    fun setFavorite() {
        val movie = getMovie().value
        if (movie != null) {
            if (type == "movies") {
                val movieEntity: MovieEntity
                movie.let {
                    movieEntity = MovieEntity(
                        it.id,
                        it.title,
                        it.overview,
                        it.poster,
                        it.language,
                        it.runtime,
                        it.gendre,
                        it.favorite,
                    )

                }
                val newState = movieEntity.favorite
                movieRepository.setFavoriteMovie(movieEntity, newState)
            } else {
                val tvShowEntity: TVShowEntity
                movie.let {
                    tvShowEntity = TVShowEntity(
                        it.id,
                        it.title,
                        it.overview,
                        it.poster,
                        it.language,
                        it.runtime,
                        it.gendre,
                        it.favorite,
                    )

                }
                val newState = tvShowEntity.favorite
                movieRepository.setFavoriteTVShow(tvShowEntity, newState)
            }
        }
    }

}