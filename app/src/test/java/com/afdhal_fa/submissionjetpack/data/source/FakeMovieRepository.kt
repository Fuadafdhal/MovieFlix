package com.afdhal_fa.submissionjetpack.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.afdhal_fa.submissionjetpack.data.source.local.entity.MovieEntity
import com.afdhal_fa.submissionjetpack.data.source.remote.RemoteDataSource
import com.afdhal_fa.submissionjetpack.data.source.remote.response.MovieResponse

class FakeMovieRepository(private val remoteDataSource: RemoteDataSource) : MovieDataResource {

    override fun getAllMovie(): LiveData<List<MovieEntity>> {
        val movieResults = MutableLiveData<List<MovieEntity>>()

        remoteDataSource.getAllMovie(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMovieReceived(movieResponses: List<MovieResponse>) {
                val moviesList = ArrayList<MovieEntity>()
                for (response in movieResponses) {
                    val movie = MovieEntity(
                        response.id, response.title, response.overview, response.poster, response.language, response.runtime, response.gendre
                    )
                    moviesList.add(movie)
                }
                movieResults.postValue(moviesList)
            }
        })
        return movieResults
    }

    override fun getMovieByID(movieID: String): LiveData<MovieEntity> {
        val detailResults = MutableLiveData<MovieEntity>()
        remoteDataSource.getMovie(movieID, object : RemoteDataSource.LoadDetailMovieCallback {
            override fun onDetailReceived(detailResponse: MovieResponse) {
                val _detailResults = MovieEntity(detailResponse.id, detailResponse.title, detailResponse.overview, detailResponse.poster, detailResponse.language, detailResponse.runtime, detailResponse.gendre)
                detailResults.postValue(_detailResults)
            }
        })
        return detailResults
    }

    override fun getAllTVShow(): LiveData<List<MovieEntity>> {
        val tvShowResults = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllTVShow(object : RemoteDataSource.LoadTVShowCallback {
            override fun onAllTVShowReceived(tvshowResponses: List<MovieResponse>) {
                val tvshowList = ArrayList<MovieEntity>()
                for (response in tvshowResponses) {
                    val tvshow = MovieEntity(
                        response.id, response.title, response.overview, response.poster, response.language, response.runtime, response.gendre
                    )

                    tvshowList.add(tvshow)
                }
                tvShowResults.postValue(tvshowList)
            }
        })

        return tvShowResults
    }

    override fun getTVShowByID(tvshowID: String): LiveData<MovieEntity> {
        val detailResults = MutableLiveData<MovieEntity>()
        remoteDataSource.getTVShow(tvshowID, object : RemoteDataSource.LoadDetailTVShowCallback {
            override fun onDetailReceived(detailResponse: MovieResponse) {
                val _detailResults = MovieEntity(detailResponse.id, detailResponse.title, detailResponse.overview, detailResponse.poster, detailResponse.language, detailResponse.runtime, detailResponse.gendre)
                detailResults.postValue(_detailResults)
            }
        })
        return detailResults
    }
}