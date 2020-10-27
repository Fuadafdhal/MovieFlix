package com.afdhal_fa.submissionjetpack.ui.home

import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class HomeVModelTest {
    private lateinit var viewModel: HomeVModel

    @Before
    fun setUp() {
        viewModel = HomeVModel()
    }


    @Test
    fun getMovies() {
        val movieEntities = viewModel.getMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities.size)
    }

    @Test
    fun getTVShow() {
        val movieEntities = viewModel.getTVShow()
        assertNotNull(movieEntities)
        assertEquals(11, movieEntities.size)
    }
}