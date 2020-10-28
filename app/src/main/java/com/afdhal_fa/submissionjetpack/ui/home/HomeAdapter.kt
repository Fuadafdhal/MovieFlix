package com.afdhal_fa.submissionjetpack.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afdhal_fa.submissionjetpack.R
import com.afdhal_fa.submissionjetpack.data.source.local.entity.MovieEntity
import com.afdhal_fa.submissionjetpack.ui.detail.DetailMovieActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.items_movie.view.*

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.VHolder>() {
    private var listMovies = ArrayList<MovieEntity>()
    private lateinit var _Position: String

    fun setMovie(movies: List<MovieEntity>?) {
        if (movies == null) return
        listMovies.clear()
        listMovies.addAll(movies)
    }

    fun setPosition(position: String) {
        this._Position = position
    }

    inner class VHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(mMovieEntity: MovieEntity) {
            val imageResource: Int =
                itemView.resources
                    .getIdentifier(mMovieEntity.poster, null, itemView.context.packageName)

            with(itemView) {
                tv_item_title.text = mMovieEntity.title
                this.setOnClickListener {
                    context.startActivity(Intent(context, DetailMovieActivity::class.java).apply {
                        putExtra(DetailMovieActivity.EXTRA_ID, mMovieEntity.id)
                        putExtra(DetailMovieActivity.EXTRA_POSITION, _Position)
                    })
                }

                Glide.with(context)
                    .load(imageResource)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(iv_item_image)
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        return VHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        val movieEntity = listMovies[position]
        holder.bind(movieEntity)
    }

    override fun getItemCount(): Int = listMovies.size
}