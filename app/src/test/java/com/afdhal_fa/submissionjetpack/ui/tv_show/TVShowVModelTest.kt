package com.afdhal_fa.submissionjetpack.ui.tv_show

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.afdhal_fa.submissionjetpack.data.source.MovieRepository
import com.afdhal_fa.submissionjetpack.domain.model.Movie
import com.afdhal_fa.submissionjetpack.utils.DataDummy
import com.dicoding.academies.vo.Resource
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
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

    @Mock
    private lateinit var observerFavorite: Observer<List<Movie>>

    @Before
    fun setup() {
        viewModel = TVShowVModel(movieRepository)
    }

    @Test
    fun getTVShow() {
        val dummyCourses = Resource.success(DataDummy.generateDummyTVShow())
        val courses = MutableLiveData<Resource<List<Movie>>>()
        courses.value = dummyCourses

        `when`(movieRepository.getAllTVShow()).thenReturn(courses)
        val courseEntities = viewModel.getTVShow().value?.data
        verify(movieRepository).getAllTVShow()
        assertNotNull(courseEntities)
        assertEquals(11, courseEntities?.size)

        viewModel.getTVShow().observeForever(observer)
        verify(observer).onChanged(dummyCourses)
    }

    @Test
    fun getMoviesFavorite() {
        val dummyCourses = DataDummy.generateDummyTVShow()
        val courses = MutableLiveData<List<Movie>>()
        courses.value = dummyCourses

        `when`(movieRepository.getTVShowFavorite()).thenReturn(courses)
        val courseEntities = viewModel.getTVShowFavorite().value
        verify(movieRepository).getTVShowFavorite()
        assertNotNull(courseEntities)
        assertEquals(11, courseEntities?.size)

        viewModel.getTVShowFavorite().observeForever(observerFavorite)
        verify(observerFavorite).onChanged(dummyCourses)
    }
}