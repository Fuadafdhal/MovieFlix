package com.afdhal_fa.submissionjetpack.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.afdhal_fa.submissionjetpack.data.source.MovieRepository
import com.afdhal_fa.submissionjetpack.domain.model.Movie
import com.afdhal_fa.submissionjetpack.utils.DataDummy
import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTVShowVModelTest {
    private lateinit var viewModel: DetailMovieVModel
    private val dummyTVShow = DataDummy.generateDummyTVShow()[0]
    private val tvshowId = dummyTVShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Movie>


    @Before
    fun setUp() {
        viewModel = DetailMovieVModel(movieRepository)
        viewModel.setSelectedMovie(tvshowId, "tv_show")
    }


    @Test
    fun getTVShow() {
        val tvShow = MutableLiveData<Movie>()
        tvShow.value = dummyTVShow

        `when`(movieRepository.getTVShowByID(tvshowId)).thenReturn(tvShow)
        val tvShowEntity = viewModel.getMovie().value as Movie
        verify(movieRepository).getTVShowByID(tvshowId)
        Assert.assertNotNull(tvShowEntity)
        assertEquals(dummyTVShow.id, tvShowEntity.id)
        assertEquals(dummyTVShow.title, tvShowEntity.title)
        assertEquals(dummyTVShow.overview, tvShowEntity.overview)
        assertEquals(dummyTVShow.poster, tvShowEntity.poster)
        assertEquals(dummyTVShow.language, tvShowEntity.language)
        assertEquals(dummyTVShow.runtime, tvShowEntity.runtime)
        assertEquals(dummyTVShow.gendre, tvShowEntity.gendre)

        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyTVShow)
    }
}