package com.afdhal_fa.submissionjetpack.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.afdhal_fa.submissionjetpack.R
import com.afdhal_fa.submissionjetpack.domain.model.Movie
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


    internal lateinit var viewModel: DetailMovieVModel
    private var menu: Menu? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val factory = ViewModelFactory.getInstance(applicationContext)
        viewModel = ViewModelProvider(this, factory)[DetailMovieVModel::class.java]

        val extras = intent.extras

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)

        if (extras != null) {
            val movieId = extras.getString(EXTRA_ID)
            val position = extras.getString(EXTRA_POSITION)
            if (movieId != null && position != null) {
                viewModel.setSelectedMovie(movieId, position)
                progress_bar.visibility = View.VISIBLE
                tv_original_language.visibility = View.GONE
                tv_runtime.visibility = View.GONE
                tv_genres.visibility = View.GONE
                viewModel.getMovie().observe(this, {
                    progress_bar.visibility = View.GONE
                    tv_original_language.visibility = View.VISIBLE
                    tv_runtime.visibility = View.VISIBLE
                    tv_genres.visibility = View.VISIBLE
                    setMovie(it)
                })
            }
        }
    }

    private fun setMovie(movie: Movie) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back)

        fab.visibility = View.VISIBLE

        val imageResource: Int = resources.getIdentifier(movie.poster, null, packageName)
        Glide.with(this).load(imageResource).apply(
            RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
        ).into(text_detail_image)

        toolbar.title = movie.title
        tv_overview.text = movie.overview
        tv_original_language.text = movie.language
        tv_runtime.text = movie.runtime
        tv_genres.text = movie.gendre

        fab.setOnClickListener {
            viewModel.setFavorite()
            viewModel.getMovie().observe(this, {
                setMovie(it)
                setStatusFavorite(it.favorite)
            })

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return false
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_active))
        } else {
            fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_unactive))
        }
    }
}