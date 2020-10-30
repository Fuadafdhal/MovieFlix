package com.afdhal_fa.submissionjetpack.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.afdhal_fa.submissionjetpack.data.source.remote.RemoteDataSource
import com.afdhal_fa.submissionjetpack.utils.DataDummy
import org.junit.Rule
import org.mockito.Mockito

class MovieRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val academyRepository = FakeMovieRepository(remote)

    private val movieResponses = DataDummy.generateRemoteDummyMovie()
    private val movieResponsesByID = movieResponses[0]
    private val movieId = movieResponses[0].id

    private val tvshowResponses = DataDummy.generateRemoteDummyTVShow()
    private val tvshowResponsesByID = tvshowResponses[0]
    private val tvshowId = tvshowResponses[0].id

    //
    //    @Test
    //    fun getAllMovie() {
    //        doAnswer { invocation ->
    //            (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback).onAllMovieReceived(movieResponses)
    //            null
    //        }.`when`(remote).getAllMovie(any())
    //
    //        val courseEntities = LiveDataTestUtil.getValue(academyRepository.getAllMovie())
    //        verify(remote).getAllMovie(any())
    //        assertNotNull(courseEntities)
    //        assertEquals(movieResponses.size.toLong(), courseEntities.size.toLong())
    //    }
    //
    //    @Test
    //    fun getAllMovieByID() {
    //        doAnswer { invocation ->
    //            (invocation.arguments[1] as RemoteDataSource.LoadDetailMovieCallback)
    //                .onDetailReceived(movieResponsesByID)
    //            null
    //        }.`when`(remote).getMovie(eq(movieId), any())
    //
    //        val movieEntity = LiveDataTestUtil.getValue(academyRepository.getMovieByID(movieId))
    //        verify(remote).getMovie(eq(movieId), any())
    //        assertNotNull(movieEntity)
    //    }
    //
    //    @Test
    //    fun getAllTVShow() {
    //        doAnswer { invocation ->
    //            (invocation.arguments[0] as RemoteDataSource.LoadTVShowCallback).onAllTVShowReceived(tvshowResponses)
    //        }.`when`(remote).getAllTVShow(any())
    //
    //        val courseEntities = LiveDataTestUtil.getValue(academyRepository.getAllTVShow())
    //        verify(remote).getAllTVShow(any())
    //        assertNotNull(courseEntities)
    //        assertEquals(tvshowResponses.size.toLong(), courseEntities.size.toLong())
    //    }
    //
    //    @Test
    //    fun getAllTVShowByID() {
    //        doAnswer { invocation ->
    //            (invocation.arguments[1] as RemoteDataSource.LoadDetailTVShowCallback)
    //                .onDetailReceived(tvshowResponsesByID)
    //            null
    //        }.`when`(remote).getTVShow(eq(tvshowId), any())
    //
    //        val moduleEntities = LiveDataTestUtil.getValue(academyRepository.getTVShowByID(tvshowId))
    //        verify(remote).getTVShow(eq(tvshowId), any())
    //        assertNotNull(moduleEntities)
    //    }
}