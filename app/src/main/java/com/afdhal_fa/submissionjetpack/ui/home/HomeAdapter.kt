package com.afdhal_fa.submissionjetpack.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.afdhal_fa.submissionjetpack.R
import com.afdhal_fa.submissionjetpack.domain.model.Movie
import com.afdhal_fa.submissionjetpack.ui.detail.DetailMovieActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.items_movie.view.*

class HomeAdapter internal constructor() : PagedListAdapter<Movie, HomeAdapter.VHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
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
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
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
}