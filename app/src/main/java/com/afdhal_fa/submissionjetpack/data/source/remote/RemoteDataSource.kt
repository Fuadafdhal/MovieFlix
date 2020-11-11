package com.afdhal_fa.submissionjetpack.data.source.remote

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.afdhal_fa.submissionjetpack.data.source.remote.response.MovieResponse
import com.afdhal_fa.submissionjetpack.utils.EspressoIdlingResource
import com.afdhal_fa.submissionjetpack.utils.JsonHelper

class RemoteDataSource private constructor(private val jsonHelper: JsonHelper) {

    private val handler = Handler()

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(helper: JsonHelper): RemoteDataSource = instance ?: synchronized(this) {
            instance ?: RemoteDataSource(helper)
        }
    }

    fun getAllMovie(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovies = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultMovies.value = ApiResponse.success(jsonHelper.loadMovie())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)

        return resultMovies
    }

    fun getMovie(id: String): LiveData<ApiResponse<MovieResponse>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<MovieResponse>>()
        handler.postDelayed({
            resultMovie.value = ApiResponse.success(jsonHelper.loadMovieByID(id))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovie
    }


    fun getAllTVShow(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultTVShows = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultTVShows.value = ApiResponse.success(jsonHelper.loadTVShow())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)

        return resultTVShows
    }

    fun getTVShow(id: String): LiveData<ApiResponse<MovieResponse>> {
        EspressoIdlingResource.increment()
        val resultTVShow = MutableLiveData<ApiResponse<MovieResponse>>()
        handler.postDelayed({
            resultTVShow.value = ApiResponse.success(jsonHelper.loadTVShowByID(id))
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultTVShow
    }
}
