package com.afdhal_fa.submissionjetpack.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.afdhal_fa.submissionjetpack.data.source.local.entity.MovieEntity
import com.afdhal_fa.submissionjetpack.data.source.local.entity.TVShowEntity
import com.afdhal_fa.submissionjetpack.data.source.local.room.MovieDao

class LocalDataSource private constructor(private val mMoviesDao: MovieDao) {
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource = INSTANCE ?: LocalDataSource(movieDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mMoviesDao.getMovies()

    fun getAllTVShow(): DataSource.Factory<Int, TVShowEntity> = mMoviesDao.getTVShow()

    fun getMovieByID(movieID: String): LiveData<MovieEntity> = mMoviesDao.getMoviesByID(movieID)

    fun getTVShowByID(tvShowID: String): LiveData<TVShowEntity> = mMoviesDao.getTVShowByID(tvShowID)

    fun getAllMoviesFavorite(): DataSource.Factory<Int, MovieEntity> = mMoviesDao.getMoviesFavoritre()

    fun getAllTVShowFavorite(): DataSource.Factory<Int, TVShowEntity> = mMoviesDao.getTVShowFavoritre()

    fun insertMovie(movie: List<MovieEntity>) = mMoviesDao.insertMovie(movie)

    fun insertTVShow(tvShow: List<TVShowEntity>) = mMoviesDao.insertTVShow(tvShow)

    fun setMovieFavorite(movie: MovieEntity, newState: Boolean) {
        movie.favorite = newState
        mMoviesDao.updateMovie(movie)
    }

    fun setTVShowFavorite(tvShow: TVShowEntity, newState: Boolean) {
        tvShow.favorite = newState
        mMoviesDao.updateTVShow(tvShow)
    }

}