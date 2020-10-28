package com.afdhal_fa.submissionjetpack.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.afdhal_fa.submissionjetpack.R
import com.afdhal_fa.submissionjetpack.ui.movie.MovieFragment
import com.afdhal_fa.submissionjetpack.ui.tv_show.TVShowFragment
import com.afdhal_fa.submissionjetpack.utils.VPager
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val pages = ArrayList<VPager>()
        pages.add(VPager(getString(R.string.label_movie), MovieFragment()))
        pages.add(VPager(getString(R.string.label_tv_show), TVShowFragment()))

        val vPagerAdapater = VPagerAdapater(pages, supportFragmentManager)
        vPagerAdapater.setData("movies", "tv_show")
        view_pager.adapter = vPagerAdapater
        tabs.setupWithViewPager(view_pager)
    }
}