package com.afdhal_fa.submissionjetpack.ui.tv_show

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.afdhal_fa.submissionjetpack.data.source.MovieRepository
import com.afdhal_fa.submissionjetpack.data.source.local.entity.MovieEntity
import com.afdhal_fa.submissionjetpack.utils.DataDummy
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
class TVShowVModelTest {
    private lateinit var viewModel: TVShowVModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<MovieEntity>>

    @Before
    fun setup() {
        viewModel = TVShowVModel(movieRepository)
    }

    @Test
    fun getTVShow() {
        val dummyTVShow = DataDummy.generateDummyMovie()
        val tvShows = MutableLiveData<List<MovieEntity>>()
        tvShows.value = dummyTVShow

        `when`(movieRepository.getAllTVShow()).thenReturn(tvShows)
        val courseEntities = viewModel.getTVShow().value
        verify<MovieRepository>(movieRepository).getAllTVShow()
        Assert.assertNotNull(courseEntities)
        Assert.assertEquals(10, courseEntities?.size)

        viewModel.getTVShow().observeForever(observer)
        verify(observer).onChanged(dummyTVShow)
    }
}