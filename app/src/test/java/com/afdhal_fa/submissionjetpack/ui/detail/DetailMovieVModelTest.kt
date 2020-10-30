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
class DetailMovieVModelTest {
    private lateinit var viewModel: DetailMovieVModel
    private val dummyMovie = DataDummy.generateDummyMovie()[0]
    private val movieId = dummyMovie.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Movie>


    @Before
    fun setUp() {
        viewModel = DetailMovieVModel(movieRepository)
        viewModel.setSelectedMovie(movieId, "movies")
    }

    @Test
    fun getMovie() {

        val movie = MutableLiveData<Movie>()
        movie.value = dummyMovie

        `when`(movieRepository.getMovieByID(movieId)).thenReturn(movie)
        val movieEntity = viewModel.getMovie().value as Movie
        verify(movieRepository).getMovieByID(movieId)
        Assert.assertNotNull(movieEntity)
        assertEquals(dummyMovie.id, movieEntity.id)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.poster, movieEntity.poster)
        assertEquals(dummyMovie.language, movieEntity.language)
        assertEquals(dummyMovie.runtime, movieEntity.runtime)
        assertEquals(dummyMovie.gendre, movieEntity.gendre)

        viewModel.getMovie().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}