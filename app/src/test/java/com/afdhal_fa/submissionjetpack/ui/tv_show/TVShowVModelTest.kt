package com.afdhal_fa.submissionjetpack.ui.tv_show

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.afdhal_fa.submissionjetpack.data.source.MovieRepository
import com.afdhal_fa.submissionjetpack.domain.model.Movie
import com.afdhal_fa.submissionjetpack.utils.DataDummy
import com.dicoding.academies.vo.Resource
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
    private lateinit var observer: Observer<Resource<List<Movie>>>

    @Before
    fun setup() {
        viewModel = TVShowVModel(movieRepository)
    }

    @Test
    fun getTVShow() {
        val dummyTVShow = Resource.success(DataDummy.generateDummyMovie())
        val tvShows = MutableLiveData<Resource<List<Movie>>>()
        tvShows.value = dummyTVShow

        `when`(movieRepository.getAllTVShow()).thenReturn(tvShows)
        val courseEntities = viewModel.getTVShow().value
        verify(movieRepository).getAllTVShow()
        Assert.assertNotNull(courseEntities)
        Assert.assertEquals(10, courseEntities?.data?.size)

        viewModel.getTVShow().observeForever(observer)
        verify(observer).onChanged(dummyTVShow)
    }
}