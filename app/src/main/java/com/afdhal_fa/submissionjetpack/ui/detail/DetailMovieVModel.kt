package com.afdhal_fa.submissionjetpack.ui.detail

import androidx.lifecycle.ViewModel
import com.afdhal_fa.submissionjetpack.model.MovieEntity
import com.afdhal_fa.submissionjetpack.utils.DataDummy

class DetailMovieVModel : ViewModel() {

    private lateinit var movieId: String
    private lateinit var type: String

    fun setSelectedMovie(movieId: String, type: String) {
        this.movieId = movieId
        this.type = type
    }

    fun getMovie(): MovieEntity {
        lateinit var mMovies: MovieEntity
        val movieEntities =
            if (type == "movies") DataDummy.generateDummyMovie() else DataDummy.generateDummyTVShow()
        for (mMoviesEntity in movieEntities) {
            if (mMoviesEntity.id == movieId) {
                mMovies = mMoviesEntity
            }
        }

        return mMovies
    }
}