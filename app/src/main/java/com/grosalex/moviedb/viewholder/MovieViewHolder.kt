package com.grosalex.moviedb.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.grosalex.moviedb.R
import com.grosalex.moviedb.api.MovieService
import com.grosalex.moviedb.model.Movie
import com.squareup.picasso.Picasso

class MovieViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater
        .from(parent.context)
        .inflate(R.layout.movie_item, parent, false)
) {
    private val ivPoster:ImageView = itemView.findViewById(R.id.iv_poster)
    private val tvTitle:TextView = itemView.findViewById(R.id.tv_title)
    private val tvReleaseDate:TextView= itemView.findViewById(R.id.tv_release_date)
    private val tvOverview: TextView = itemView.findViewById(R.id.tv_overview)
    fun bind(movie: Movie) {
        Picasso.get().load(MovieService.IMAGE_ROOT+movie.backdropUrl).into(ivPoster)
        tvTitle.text = movie.title
        tvReleaseDate.text = movie.releaseDate
        tvOverview.text = movie.overview
    }
}