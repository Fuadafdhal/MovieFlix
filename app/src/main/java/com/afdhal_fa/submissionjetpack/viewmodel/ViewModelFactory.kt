package com.afdhal_fa.submissionjetpack.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.afdhal_fa.submissionjetpack.data.source.MovieRepository
import com.afdhal_fa.submissionjetpack.di.Injection
import com.afdhal_fa.submissionjetpack.ui.detail.DetailMovieVModel
import com.afdhal_fa.submissionjetpack.ui.movie.MovieVModel
import com.afdhal_fa.submissionjetpack.ui.tv_show.TVShowVModel

class ViewModelFactory private constructor(private val mMovieRepository: MovieRepository) :
        ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory = instance ?: synchronized(this) {
            instance ?: ViewModelFactory(Injection.provideRepository(context))
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when {
            modelClass.isAssignableFrom(MovieVModel::class.java) -> {
                return MovieVModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(TVShowVModel::class.java) -> {
                return TVShowVModel(mMovieRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieVModel::class.java) -> {
                return DetailMovieVModel(mMovieRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}