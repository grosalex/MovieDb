package com.grosalex.moviedb.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.grosalex.moviedb.model.Trailer
import com.grosalex.moviedb.viewholder.TraileViewHolder

class TrailerAdapter(val trailers:ArrayList<Trailer>) : RecyclerView.Adapter<TraileViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TraileViewHolder = TraileViewHolder(parent)

    override fun getItemCount(): Int = trailers.size

    override fun onBindViewHolder(holder: TraileViewHolder, position: Int) {
        holder.bind(trailers[position])
    }
}