package com.afdhal_fa.submissionjetpack.data.source.remote

import android.os.Handler
import com.afdhal_fa.submissionjetpack.data.source.remote.response.MovieResponse
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

    fun getAllMovie(callback: LoadMovieCallback) {
        handler.postDelayed({ callback.onAllMovieReceived(jsonHelper.loadMovie()) }, SERVICE_LATENCY_IN_MILLIS)

    }

    fun getMovie(id: String, callback: LoadDetailMovieCallback) {
        handler.postDelayed({
            callback.onDetailReceived(
                jsonHelper.loadMovieByID(id)
            )
        }, SERVICE_LATENCY_IN_MILLIS)
    }


    fun getAllTVShow(callback: LoadTVShowCallback) {
        handler.postDelayed({ callback.onAllTVShowReceived(jsonHelper.loadTVShow()) }, SERVICE_LATENCY_IN_MILLIS)

    }

    fun getTVShow(id: String, callback: LoadDetailTVShowCallback) {
        handler.postDelayed({
            callback.onDetailReceived(
                jsonHelper.loadTVShowByID(id)
            )
        }, SERVICE_LATENCY_IN_MILLIS)
    }


    interface LoadMovieCallback {
        fun onAllMovieReceived(movieResponses: List<MovieResponse>)
    }

    interface LoadTVShowCallback {
        fun onAllTVShowReceived(tvshowResponses: List<MovieResponse>)
    }

    interface LoadDetailMovieCallback {
        fun onDetailReceived(detailResponse: MovieResponse)
    }

    interface LoadDetailTVShowCallback {
        fun onDetailReceived(detailResponse: MovieResponse)
    }
}
