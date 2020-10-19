package com.afdhal_fa.submissionjetpack.ui.detail

import android.content.Context
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

    fun getMovie(context: Context): MovieEntity {
        lateinit var mMovies: MovieEntity
        val movieEntities =
            if (type.equals("movies")) DataDummy.generateDummyMovie(context) else DataDummy.generateDummyTVShow(context)
        for (mMoviesEntity in movieEntities) {
            if (mMoviesEntity.id == movieId) {
                mMovies = mMoviesEntity
            }
        }

        return mMovies
    }
}