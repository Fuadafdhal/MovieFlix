package com.afdhal_fa.submissionjetpack.ui.home

import android.app.Application
import android.content.Context
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class HomeVModelTest {
    private lateinit var viewModel: HomeVModel
    private lateinit var context: Context

    @Before
    fun setUp() {
        viewModel = HomeVModel()
    }


    @Test
    fun getMovies() {
//        val courseEntities = viewModel.getMovies(context)
//        assertNotNull(courseEntities)
//        assertEquals(5, courseEntities.size)
    }

    @Test
    fun getTVShow() {
    }
}