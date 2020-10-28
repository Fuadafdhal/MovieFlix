package com.afdhal_fa.submissionjetpack.data.source

import androidx.lifecycle.LiveData
import com.afdhal_fa.submissionjetpack.data.source.local.entity.MovieEntity

interface MovieDataResource {
    fun getAllMovie(): LiveData<List<MovieEntity>>

    fun getMovieByID(movieID: String): LiveData<MovieEntity>

    fun getAllTVShow(): LiveData<List<MovieEntity>>

    fun getTVShowByID(tvshowID: String): LiveData<MovieEntity>
}