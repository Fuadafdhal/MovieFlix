package com.afdhal_fa.submissionjetpack.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.afdhal_fa.submissionjetpack.R
import com.afdhal_fa.submissionjetpack.model.MovieEntity
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


        val vModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailMovieVModel::class.java]

        val extras = intent.extras

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)

        if (extras != null) {
            val movieId = extras.getString(EXTRA_ID)
            val position = extras.getString(EXTRA_POSITION)
            if (movieId != null && position != null) {
                vModel.setSelectedMovie(movieId, position)
                setMovie(vModel.getMovie(applicationContext))
            }
        }
    }

    private fun setMovie(movieEntity: MovieEntity) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)

        val imageResource: Int = getResources()
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