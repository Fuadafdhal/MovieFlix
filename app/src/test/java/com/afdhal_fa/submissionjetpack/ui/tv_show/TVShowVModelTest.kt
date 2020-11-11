package com.afdhal_fa.submissionjetpack.ui.tv_show

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.afdhal_fa.submissionjetpack.data.source.MovieRepository
import com.afdhal_fa.submissionjetpack.domain.model.Movie
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
    private lateinit var observer: Observer<Resource<PagedList<Movie>>>

    @Mock
    private lateinit var pagedList: PagedList<Movie>

    @Before
    fun setup() {
        viewModel = TVShowVModel(movieRepository)
    }

    @Test
    fun getTVShow() {
        val dummyCourses = Resource.success(pagedList)
        `when`(dummyCourses.data?.size).thenReturn(10)
        val courses = MutableLiveData<Resource<PagedList<Movie>>>()
        courses.value = dummyCourses

        `when`(movieRepository.getAllTVShow()).thenReturn(courses)
        val courseEntities = viewModel.getTVShow().value?.data
        verify(movieRepository).getAllTVShow()
        assertNotNull(courseEntities)
        assertEquals(10, courseEntities?.size)

        viewModel.getTVShow().observeForever(observer)
        verify(observer).onChanged(dummyCourses)
    }
}