package com.afdhal_fa.submissionjetpack.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.afdhal_fa.submissionjetpack.data.source.MovieRepository
import com.afdhal_fa.submissionjetpack.data.source.local.entity.MovieEntity
import com.afdhal_fa.submissionjetpack.domain.model.Movie
import com.afdhal_fa.submissionjetpack.utils.DataMaperTest
import com.dicoding.academies.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieVModelTest {

    private lateinit var viewModel: MovieVModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<Movie>>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setup() {
        viewModel = MovieVModel(movieRepository)
    }

    @Test
    fun getMovies() {
        val dummyCourses = Resource.success(pagedList)
        `when`(dummyCourses.data?.size).thenReturn(5)
        val courses = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        courses.value = dummyCourses
        //
        `when`(movieRepository.getAllMovie()).thenReturn(DataMaperTest.mapMovieEntityToMoviePagedList(courses))
        //        val courseEntities = viewModel.getMovies().value?.data
        //        verify(movieRepository).getAllMovie()
        //        assertNotNull(courseEntities)
        //        assertEquals(5, courseEntities?.size)
        //
        //        viewModel.getMovies().observeForever(observer)
        //        verify(observer).onChanged(dummyCourses)
    }
}