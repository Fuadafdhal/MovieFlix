package com.afdhal_fa.submissionjetpack.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.afdhal_fa.submissionjetpack.R
import com.afdhal_fa.submissionjetpack.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovie()
    private val dummyTVShow = DataDummy.generateDummyTVShow()

    @get:Rule
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun loadMovie() {
        Espresso.onView(withId(R.id.recycleview))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.recycleview))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        Espresso.onView(withId(R.id.recycleview)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )

        Espresso.onView(withId(R.id.tv_overview))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_overview))
            .check(ViewAssertions.matches(withText(dummyMovie[0].overview)))

        Espresso.onView(withId(R.id.tv_original_language))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_original_language))
            .check(ViewAssertions.matches(withText(dummyMovie[0].language)))

        Espresso.onView(withId(R.id.tv_runtime))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_runtime))
            .check(ViewAssertions.matches(withText(dummyMovie[0].runtime)))

        Espresso.onView(withId(R.id.tv_genres))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_genres))
            .check(ViewAssertions.matches(withText(dummyMovie[0].gendre)))
    }

    @Test
    fun loadTVShow() {
        Espresso.onView(withText("TV Show")).perform(ViewActions.click())
        Espresso.onView(withId(R.id.recycleview_tv_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.recycleview_tv_show))
            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTVShow.size))
    }

    @Test
    fun loadDetailTVShow() {
        Espresso.onView(withText("TV Show")).perform(ViewActions.click())

        Espresso.onView(withId(R.id.recycleview_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )

        Espresso.onView(withId(R.id.tv_overview))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_overview))
            .check(ViewAssertions.matches(withText(dummyTVShow[0].overview)))

        Espresso.onView(withId(R.id.tv_original_language))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_original_language))
            .check(ViewAssertions.matches(withText(dummyTVShow[0].language)))

        Espresso.onView(withId(R.id.tv_runtime))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_runtime))
            .check(ViewAssertions.matches(withText(dummyTVShow[0].runtime)))

        Espresso.onView(withId(R.id.tv_genres))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(withId(R.id.tv_genres))
            .check(ViewAssertions.matches(withText(dummyTVShow[0].gendre)))
    }
}