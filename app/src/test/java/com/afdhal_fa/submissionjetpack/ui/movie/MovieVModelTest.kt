package com.afdhal_fa.submissionjetpack.ui.movie

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
class MovieVModelTest {

    private lateinit var viewModel: MovieVModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<List<Movie>>>

    @Before
    fun setup() {
        viewModel = MovieVModel(movieRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = Resource.success(DataDummy.generateDummyMovie())
        val movies = MutableLiveData<Resource<List<Movie>>>()
        movies.value = dummyMovies

        `when`(movieRepository.getAllMovie()).thenReturn(movies)
        val courseEntities = viewModel.getMovies().value
        verify(movieRepository).getAllMovie()
        Assert.assertNotNull(courseEntities)
        Assert.assertEquals(10, courseEntities?.data?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}