package com.afdhal_fa.submissionjetpack.ui.detail

import com.afdhal_fa.submissionjetpack.utils.DataDummy
import junit.framework.Assert.assertEquals
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DetailTVShowVModelTest {
    private lateinit var viewModel: DetailMovieVModel
    private val dummyCourse = DataDummy.generateDummyTVShow()[0]
    private val courseId = dummyCourse.id


    @Before
    fun setUp() {
        viewModel = DetailMovieVModel()
        viewModel.setSelectedMovie(courseId, "tv_show")
    }


    @Test
    fun getTVShow() {
        viewModel.setSelectedMovie(dummyCourse.id, "tv_show")
        val tvShowEntity = viewModel.getMovie()
        Assert.assertNotNull(tvShowEntity)
        assertEquals(dummyCourse.id, tvShowEntity.id)
        assertEquals(dummyCourse.title, tvShowEntity.title)
        assertEquals(dummyCourse.overview, tvShowEntity.overview)
        assertEquals(dummyCourse.poster, tvShowEntity.poster)
        assertEquals(dummyCourse.language, tvShowEntity.language)
        assertEquals(dummyCourse.runtime, tvShowEntity.runtime)
        assertEquals(dummyCourse.gendre, tvShowEntity.gendre)
    }
}