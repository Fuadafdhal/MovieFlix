package com.afdhal_fa.submissionjetpack.data.source

import com.afdhal_fa.submissionjetpack.data.source.remote.RemoteDataSource
import com.afdhal_fa.submissionjetpack.utils.DataDummy
import com.afdhal_fa.submissionjetpack.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito

class MovieRepositoryTest {
    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val academyRepository = FakeMovieRepository(remote)

    private val movieResponses = DataDummy.generateRemoteDummyMovie()
    private val movieResponsesByID = movieResponses[0]
    private val movieId = movieResponses[0].id

    private val tvshowResponses = DataDummy.generateRemoteDummyTVShow()
    private val tvshowResponsesByID = tvshowResponses[0]
    private val tvshowId = tvshowResponses[0].id


    @Test
    fun getAllMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback).onAllMovieReceived(movieResponses)
            null
        }.`when`(remote).getAllMovie(any())

        val courseEntities = LiveDataTestUtil.getValue(academyRepository.getAllMovie())
        verify(remote).getAllMovie(any())
        assertNotNull(courseEntities)
        assertEquals(movieResponses.size.toLong(), courseEntities.size.toLong())
    }

    @Test
    fun getAllMovieByID() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadDetailMovieCallback).onDetailReceived(movieResponsesByID)
            null
        }.`when`(remote).getMovie(movieId, any())

        val moduleEntities = LiveDataTestUtil.getValue(academyRepository.getMovieByID(movieId))
        verify(remote).getMovie(movieId, any())
        assertNotNull(moduleEntities)
    }

    @Test
    fun getAllTVShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTVShowCallback).onAllTVShowReceived(tvshowResponses)
        }.`when`(remote).getAllTVShow(any())

        val courseEntities = LiveDataTestUtil.getValue(academyRepository.getAllTVShow())
        verify(remote).getAllTVShow(any())
        assertNotNull(courseEntities)
        assertEquals(tvshowResponses.size.toLong(), courseEntities.size.toLong())
    }

    @Test
    fun getAllTVShowByID() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadDetailTVShowCallback).onDetailReceived(tvshowResponsesByID)
            null
        }.`when`(remote).getTVShow(tvshowId, any())
        val moduleEntities = LiveDataTestUtil.getValue(academyRepository.getTVShowByID(tvshowId))
        verify(remote).getTVShow(tvshowId, any())
        assertNotNull(moduleEntities)
    }
}