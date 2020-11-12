package com.afdhal_fa.submissionjetpack.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afdhal_fa.submissionjetpack.R
import com.afdhal_fa.submissionjetpack.domain.model.Movie
import com.afdhal_fa.submissionjetpack.ui.detail.DetailMovieActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.items_movie.view.*
import java.util.*

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.VHolder>() {

    private var listMovie = ArrayList<Movie>()

    fun setMovies(movie: List<Movie>?) {
        if (movie == null) return
        this.listMovie.clear()
        this.listMovie.addAll(movie)
    }

    private lateinit var _Position: String
    fun setPosition(position: String) {
        this._Position = position
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VHolder {
        return VHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    inner class VHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(mMovie: Movie) {
            val imageResource: Int = itemView.resources.getIdentifier(mMovie.poster, null, itemView.context.packageName)

            with(itemView) {
                tv_item_title.text = mMovie.title
                this.setOnClickListener {
                    context.startActivity(Intent(context, DetailMovieActivity::class.java).apply {
                        putExtra(DetailMovieActivity.EXTRA_ID, mMovie.id)
                        putExtra(DetailMovieActivity.EXTRA_POSITION, _Position)
                    })
                }

                Glide.with(context).load(imageResource).apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
                ).into(iv_item_image)
            }
        }
    }

    override fun getItemCount() = listMovie.size
}