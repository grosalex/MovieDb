package com.grosalex.moviedb.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.grosalex.moviedb.model.Movie
import com.grosalex.moviedb.viewholder.MovieViewHolder

class MoviesAdapter(val movies: ArrayList<Movie>) : RecyclerView.Adapter<MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder = MovieViewHolder(parent)

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }
}