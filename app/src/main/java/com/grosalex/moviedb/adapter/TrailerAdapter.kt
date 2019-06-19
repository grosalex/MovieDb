package com.grosalex.moviedb.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.grosalex.moviedb.model.Trailer
import com.grosalex.moviedb.viewholder.TrailerViewHolder

class TrailerAdapter(val trailers:ArrayList<Trailer>) : RecyclerView.Adapter<TrailerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailerViewHolder = TrailerViewHolder(parent)

    override fun getItemCount(): Int = trailers.size

    override fun onBindViewHolder(holder: TrailerViewHolder, position: Int) {
        holder.bind(trailers[position])
    }
}