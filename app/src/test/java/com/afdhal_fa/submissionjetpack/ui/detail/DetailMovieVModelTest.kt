package com.afdhal_fa.submissionjetpack.ui.detail

import com.afdhal_fa.submissionjetpack.utils.DataDummy
import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DetailMovieVModelTest {
    private lateinit var viewModel: DetailMovieVModel
    private val dummyCourse = DataDummy.generateDummyMovie()[0]
    private val courseId = dummyCourse.id


    @Before
    fun setUp() {
        viewModel = DetailMovieVModel()
        viewModel.setSelectedMovie(courseId, "movies")
    }


    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyCourse.id, "movies")
        val movieEntity = viewModel.getMovie()
        Assert.assertNotNull(movieEntity)
        assertEquals(dummyCourse.id, movieEntity.id)
        assertEquals(dummyCourse.title, movieEntity.title)
        assertEquals(dummyCourse.overview, movieEntity.overview)
        assertEquals(dummyCourse.poster, movieEntity.poster)
        assertEquals(dummyCourse.language, movieEntity.language)
        assertEquals(dummyCourse.runtime, movieEntity.runtime)
        assertEquals(dummyCourse.gendre, movieEntity.gendre)
    }

    @Test
    fun getTVShow() {

    }
}