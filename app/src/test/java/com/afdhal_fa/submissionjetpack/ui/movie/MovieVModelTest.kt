package com.afdhal_fa.submissionjetpack.ui.movie

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
class MovieVModelTest {

    private lateinit var viewModel: MovieVModel

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
        viewModel = MovieVModel(movieRepository)
    }

    @Test
    fun getMovies() {
        val dummyCourses = Resource.success(DataDummy.generateDummyMovie())
        val courses = MutableLiveData<Resource<List<Movie>>>()
        courses.value = dummyCourses

        `when`(movieRepository.getAllMovie()).thenReturn(courses)
        val courseEntities = viewModel.getMovies().value?.data
        verify(movieRepository).getAllMovie()
        assertNotNull(courseEntities)
        assertEquals(10, courseEntities?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyCourses)
    }


    @Test
    fun getMoviesFavorite() {
        val dummyCourses = DataDummy.generateDummyMovie()
        val courses = MutableLiveData<List<Movie>>()
        courses.value = dummyCourses

        `when`(movieRepository.getMovieFavorite()).thenReturn(courses)
        val courseEntities = viewModel.getMoviesFavorite().value
        verify(movieRepository).getMovieFavorite()
        assertNotNull(courseEntities)
        assertEquals(10, courseEntities?.size)

        viewModel.getMoviesFavorite().observeForever(observerFavorite)
        verify(observerFavorite).onChanged(dummyCourses)
    }

}