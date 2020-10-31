package com.afdhal_fa.submissionjetpack.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.afdhal_fa.submissionjetpack.data.source.local.LocalDataSource
import com.afdhal_fa.submissionjetpack.data.source.local.entity.MovieEntity
import com.afdhal_fa.submissionjetpack.data.source.local.entity.TVShowEntity
import com.afdhal_fa.submissionjetpack.data.source.remote.ApiResponse
import com.afdhal_fa.submissionjetpack.data.source.remote.RemoteDataSource
import com.afdhal_fa.submissionjetpack.data.source.remote.response.MovieResponse
import com.afdhal_fa.submissionjetpack.domain.model.Movie
import com.afdhal_fa.submissionjetpack.utils.AppExecutors
import com.afdhal_fa.submissionjetpack.utils.DataMapper
import com.dicoding.academies.vo.Resource

class MovieRepository private constructor(
    private val remoteDataSource: RemoteDataSource, private val localDataResource: LocalDataSource, private val appExecutors: AppExecutors
) : MovieDataResource {

    companion object {
        @Volatile
        private var instance: MovieRepository? = null

        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData, localData, appExecutors)
            }
    }

    override fun getAllMovie(): LiveData<Resource<List<Movie>>> {
        return object : NetworkBoundResource<List<Movie>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<Movie>> =
                Transformations.map(localDataResource.getAllMovies(), { DataMapper.mapMovieEntityToMovie(it) })

            override fun shouldFetch(data: List<Movie>?): Boolean = data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> = remoteDataSource.getAllMovie()

            override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        response.id,
                        response.title,
                        response.overview,
                        response.poster,
                        response.language,
                        response.runtime,
                        response.gendre,
                        false,
                    )
                    movieList.add(movie)
                }
                localDataResource.insertMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getMovieByID(movieID: String): LiveData<Movie> =
        Transformations.map(localDataResource.getMovieByID(movieID), { DataMapper.mapMovieEntityToMovieByID(it) })


    override fun getAllTVShow(): LiveData<Resource<List<Movie>>> {
        return object : NetworkBoundResource<List<Movie>, List<MovieResponse>>(appExecutors) {
            override fun loadFromDB(): LiveData<List<Movie>> =
                Transformations.map(localDataResource.getAllTVShow(), { DataMapper.mapTVShowEntityToTVShow(it) })

            override fun shouldFetch(data: List<Movie>?): Boolean = data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> = remoteDataSource.getAllTVShow()

            override fun saveCallResult(data: List<MovieResponse>) {
                val tvShowList = ArrayList<TVShowEntity>()
                for (response in data) {
                    val tvShow = TVShowEntity(
                        response.id,
                        response.title,
                        response.overview,
                        response.poster,
                        response.language,
                        response.runtime,
                        response.gendre,
                        false,
                    )
                    tvShowList.add(tvShow)
                }
                localDataResource.insertTVShow(tvShowList)
            }
        }.asLiveData()
    }

    override fun getTVShowByID(tvshowID: String): LiveData<Movie> =
        Transformations.map(localDataResource.getTVShowByID(tvshowID), { DataMapper.mapTVShowEntityToTVShowByID(it) })

    override fun getMovieFavorite(): LiveData<List<Movie>> =
        Transformations.map(localDataResource.getAllMoviesFavorite(), { DataMapper.mapMovieEntityToMovieFavorite(it) })

    override fun getTVShowFavorite(): LiveData<List<Movie>> =
        Transformations.map(localDataResource.getAllTVShowFavorite(), { DataMapper.mapTVShowEntityToTVShowFavorite(it) })


    override fun setFavoriteMovie(movieEntity: MovieEntity, states: Boolean) =
        appExecutors.diskIO().execute { localDataResource.setMovieFavorite(movieEntity, states) }


    override fun setFavoriteTVShow(tvShowEntity: TVShowEntity, states: Boolean) =
        appExecutors.diskIO().execute { localDataResource.setTVShowFavorite(tvShowEntity, states) }
}