package com.afdhal_fa.submissionjetpack.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.afdhal_fa.submissionjetpack.data.source.local.LocalDataSource
import com.afdhal_fa.submissionjetpack.data.source.remote.RemoteDataSource
import com.afdhal_fa.submissionjetpack.domain.model.Movie
import com.afdhal_fa.submissionjetpack.utils.AppExecutors
import com.afdhal_fa.submissionjetpack.utils.DataDummy
import com.afdhal_fa.submissionjetpack.utils.DataMapper
import com.afdhal_fa.submissionjetpack.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
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
    private val academyRepository = FakeMovieRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovie()
    private val movieResponsesByID = movieResponses[0]
    private val movieId = movieResponses[0].id

    private val tvshowResponses = DataDummy.generateRemoteDummyTVShow()
    private val tvshowResponsesByID = tvshowResponses[0]
    private val tvshowId = tvshowResponses[0].id


    @Test
    fun getAllMovie() {
        val dummyCourses = MutableLiveData<List<Movie>>()
        dummyCourses.value = DataDummy.generateDummyMovie()
        `when`(local.getAllMovies()).thenReturn(Transformations.map(dummyCourses, { DataMapper.mapMovieToMovieEntitys(it) }))

        val courseEntities = LiveDataTestUtil.getValue(academyRepository.getAllMovie())
        verify(local).getAllMovies()
        assertNotNull(courseEntities.data)
        assertEquals(movieResponses.size.toLong(), courseEntities.data?.size?.toLong())
    }

    @Test
    fun getAllMovieByID() {
        val dummyEntity = MutableLiveData<Movie>()
        dummyEntity.value = DataDummy.generateDummyMovieWithId()
        `when`(local.getMovieByID(movieId)).thenReturn(Transformations.map(dummyEntity, { DataMapper.mapMovieToMovieEntity(it) }))

        val movieEntity = LiveDataTestUtil.getValue(academyRepository.getMovieByID(movieId))
        verify(local).getMovieByID((movieId))
        assertNotNull(movieEntity)
        assertEquals(movieResponsesByID.overview, movieEntity.overview)
    }

    @Test
    fun getAllTVShow() {
        val dummyCourses = MutableLiveData<List<Movie>>()
        dummyCourses.value = DataDummy.generateDummyTVShow()
        `when`(local.getAllTVShow()).thenReturn(Transformations.map(dummyCourses, { DataMapper.mapTVShowToTVShowEntitys(it) }))

        val courseEntities = LiveDataTestUtil.getValue(academyRepository.getAllTVShow())
        verify(local).getAllTVShow()
        assertNotNull(courseEntities.data)
        assertEquals(tvshowResponses.size.toLong(), courseEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTVShowByID() {
        val dummyEntity = MutableLiveData<Movie>()
        dummyEntity.value = DataDummy.generateDummyTVShowWithId()
        `when`(local.getTVShowByID(tvshowId)).thenReturn(Transformations.map(dummyEntity, { DataMapper.mapTVShowToTVShowEntity(it) }))

        val tvshowEntity = LiveDataTestUtil.getValue(academyRepository.getTVShowByID(tvshowId))
        verify(local).getTVShowByID(tvshowId)
        assertNotNull(tvshowEntity)
        assertEquals(tvshowResponsesByID.overview, tvshowEntity.overview)
    }
}