package com.afdhal_fa.submissionjetpack.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.DataSource
import com.afdhal_fa.submissionjetpack.data.source.local.LocalDataSource
import com.afdhal_fa.submissionjetpack.data.source.local.entity.MovieEntity
import com.afdhal_fa.submissionjetpack.data.source.local.entity.TVShowEntity
import com.afdhal_fa.submissionjetpack.data.source.remote.RemoteDataSource
import com.afdhal_fa.submissionjetpack.domain.model.Movie
import com.afdhal_fa.submissionjetpack.utils.*
import com.dicoding.academies.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val movieRepository = FakeMovieRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovie()
    private val movieResponsesByID = movieResponses[0]
    private val movieId = movieResponses[0].id

    private val tvshowResponses = DataDummy.generateRemoteDummyTVShow()
    private val tvshowResponsesByID = tvshowResponses[0]
    private val tvshowId = tvshowResponses[0].id


    @Test
    fun getAllMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        movieRepository.getAllMovie()

        val courseEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovie()))
        verify(local).getAllMovies()
        assertNotNull(courseEntities.data)
        assertEquals(movieResponses.size.toLong(), courseEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTVShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TVShowEntity>
        `when`(local.getAllTVShow()).thenReturn(dataSourceFactory)
        movieRepository.getAllTVShow()

        val courseEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTVShow()))
        verify(local).getAllTVShow()
        assertNotNull(courseEntities.data)
        assertEquals(tvshowResponses.size.toLong(), courseEntities.data?.size?.toLong())
    }

    @Test
    fun getAllMovieByID() {
        val dummyEntity = MutableLiveData<Movie>()
        dummyEntity.value = DataDummy.generateDummyMovieWithId()
        `when`(local.getMovieByID(movieId)).thenReturn(Transformations.map(dummyEntity, { DataMapper.mapMovieToMovieEntity(it) }))

        val movieEntity = LiveDataTestUtil.getValue(movieRepository.getMovieByID(movieId))
        verify(local).getMovieByID((movieId))
        assertNotNull(movieEntity)
        assertEquals(movieResponsesByID.overview, movieEntity.overview)
    }

    @Test
    fun getAllTVShowByID() {
        val dummyEntity = MutableLiveData<Movie>()
        dummyEntity.value = DataDummy.generateDummyTVShowWithId()
        `when`(local.getTVShowByID(tvshowId)).thenReturn(Transformations.map(dummyEntity, { DataMapper.mapTVShowToTVShowEntity(it) }))

        val tvShowEntity = LiveDataTestUtil.getValue(movieRepository.getTVShowByID(tvshowId))
        verify(local).getTVShowByID(tvshowId)
        assertNotNull(tvShowEntity)
        assertEquals(tvshowResponsesByID.overview, tvShowEntity.overview)
    }

    @Test
    fun getAllMovieFavorite() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMoviesFavorite()).thenReturn(dataSourceFactory)
        movieRepository.getMovieFavorite()

        val courseEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTVShow()))
        verify(local).getAllMoviesFavorite()
        assertNotNull(courseEntities)
        assertEquals(tvshowResponses.size.toLong(), courseEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTVShowFavorite() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TVShowEntity>
        `when`(local.getAllTVShowFavorite()).thenReturn(dataSourceFactory)
        movieRepository.getTVShowFavorite()

        val courseEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTVShow()))
        verify(local).getAllTVShowFavorite()
        assertNotNull(courseEntities)
        assertEquals(tvshowResponses.size.toLong(), courseEntities.data?.size?.toLong())
    }
}