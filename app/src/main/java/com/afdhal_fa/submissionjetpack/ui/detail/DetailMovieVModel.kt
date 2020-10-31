package com.afdhal_fa.submissionjetpack.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.afdhal_fa.submissionjetpack.data.source.MovieRepository
import com.afdhal_fa.submissionjetpack.domain.model.Movie
import com.afdhal_fa.submissionjetpack.utils.DataMapper

class DetailMovieVModel(private val movieRepository: MovieRepository) : ViewModel() {

    private lateinit var movieId: String
    private lateinit var type: String

    fun setSelectedMovie(movieId: String, type: String) {
        this.movieId = movieId
        this.type = type
    }

    fun getMovie(): LiveData<Movie> = if (type == "movies" || type == "movies_favorite") movieRepository.getMovieByID(movieId)
    else movieRepository.getTVShowByID(movieId)

    fun setFavorite(movie: Movie?) {
        if (movie != null) {
            val newState = !movie.favorite
            if (type == "movies" || type == "movies_favorite") {
                movieRepository.setFavoriteMovie(DataMapper.mapMovieToMovieEntity(movie), newState)
            } else {
                movieRepository.setFavoriteTVShow(DataMapper.mapTVShowToTVShowEntity(movie), newState)
            }
        }
    }
}