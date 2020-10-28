package com.afdhal_fa.submissionjetpack.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.afdhal_fa.submissionjetpack.R
import com.afdhal_fa.submissionjetpack.data.source.local.entity.MovieEntity
import com.afdhal_fa.submissionjetpack.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail_game.*

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_ID = "EXTRA_ID_MOVIE"
        const val EXTRA_POSITION = "EXTRA_POSITION"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val factory = ViewModelFactory.getInstance(applicationContext)
        val vModel = ViewModelProvider(this, factory)[DetailMovieVModel::class.java]

        val extras = intent.extras

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)

        if (extras != null) {
            val movieId = extras.getString(EXTRA_ID)
            val position = extras.getString(EXTRA_POSITION)
            if (movieId != null && position != null) {
                vModel.setSelectedMovie(movieId, position)
                progress_bar.visibility = View.VISIBLE
                vModel.getMovie().observe(this, {
                    progress_bar.visibility = View.GONE
                    setMovie(it)
                })
            }
        }
    }

    private fun setMovie(movieEntity: MovieEntity) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)

        val imageResource: Int = resources
            .getIdentifier(movieEntity.poster, null, packageName)
        Glide.with(this)
            .load(imageResource)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(text_detail_image)

        toolbar.title = movieEntity.title
        tv_overview.text = movieEntity.overview
        tv_original_language.text = movieEntity.language
        tv_runtime.text = movieEntity.runtime
        tv_genres.text = movieEntity.gendre
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return false
    }
}