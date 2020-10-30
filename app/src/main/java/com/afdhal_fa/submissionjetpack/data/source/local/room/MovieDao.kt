package com.afdhal_fa.submissionjetpack.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.afdhal_fa.submissionjetpack.data.source.local.entity.MovieEntity
import com.afdhal_fa.submissionjetpack.data.source.local.entity.TVShowEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun getMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM tv_show")
    fun getTVShow(): LiveData<List<TVShowEntity>>

    @Query("SELECT * FROM movie where favorite = 1")
    fun getMoviesFavoritre(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM tv_show where favorite = 1")
    fun getTVShowFavoritre(): LiveData<List<TVShowEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTVShow(tvShows: List<TVShowEntity>)

    @Query("SELECT * FROM movie WHERE id = :movieID")
    fun getMoviesByID(movieID: String): LiveData<MovieEntity>

    @Query("SELECT * FROM tv_show WHERE id = :tvShowsID")
    fun getTVShowByID(tvShowsID: String): LiveData<TVShowEntity>

    @Update
    fun updateMovie(movies: MovieEntity)

    @Update
    fun updateTVShow(tvShows: TVShowEntity)
}