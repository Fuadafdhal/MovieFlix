package com.afdhal_fa.submissionjetpack.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.afdhal_fa.submissionjetpack.data.source.remote.RemoteDataSource
import com.afdhal_fa.submissionjetpack.data.source.remote.response.MovieResponse
import com.afdhal_fa.submissionjetpack.domain.model.Movie

class FakeMovieRepository(private val remoteDataSource: RemoteDataSource) : MovieDataResource {

    override fun getAllMovie(): LiveData<List<Movie>> {
        val movieResults = MutableLiveData<List<Movie>>()

        remoteDataSource.getAllMovie(object : RemoteDataSource.LoadMovieCallback {
            override fun onAllMovieReceived(movieResponses: List<MovieResponse>) {
                val moviesList = ArrayList<Movie>()
                for (response in movieResponses) {
                    val movie = Movie(
                        response.id, response.title, response.overview, response.poster, response.language, response.runtime, response.gendre
                    )
                    moviesList.add(movie)
                }
                movieResults.postValue(moviesList)
            }
        })
        return movieResults
    }

    override fun getMovieByID(movieID: String): LiveData<Movie> {
        val detailResults = MutableLiveData<Movie>()
        remoteDataSource.getMovie(movieID, object : RemoteDataSource.LoadDetailMovieCallback {
            override fun onDetailReceived(detailResponse: MovieResponse) {
                val _detailResults = Movie(
                    detailResponse.id, detailResponse.title, detailResponse.overview, detailResponse.poster, detailResponse.language,
                    detailResponse.runtime, detailResponse.gendre
                )
                detailResults.postValue(_detailResults)
            }
        })
        return detailResults
    }

    override fun getAllTVShow(): LiveData<List<Movie>> {
        val tvShowResults = MutableLiveData<List<Movie>>()
        remoteDataSource.getAllTVShow(object : RemoteDataSource.LoadTVShowCallback {
            override fun onAllTVShowReceived(tvshowResponses: List<MovieResponse>) {
                val tvshowList = ArrayList<Movie>()
                for (response in tvshowResponses) {
                    val tvshow = Movie(
                        response.id, response.title, response.overview, response.poster, response.language, response.runtime, response.gendre
                    )

                    tvshowList.add(tvshow)
                }
                tvShowResults.postValue(tvshowList)
            }
        })

        return tvShowResults
    }

    override fun getTVShowByID(tvshowID: String): LiveData<Movie> {
        val detailResults = MutableLiveData<Movie>()
        remoteDataSource.getTVShow(tvshowID, object : RemoteDataSource.LoadDetailTVShowCallback {
            override fun onDetailReceived(detailResponse: MovieResponse) {
                val _detailResults = Movie(
                    detailResponse.id, detailResponse.title, detailResponse.overview, detailResponse.poster, detailResponse.language,
                    detailResponse.runtime, detailResponse.gendre
                )
                detailResults.postValue(_detailResults)
            }
        })
        return detailResults
    }
}