package com.grosalex.moviedb.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.grosalex.moviedb.R
import com.grosalex.moviedb.model.Trailer

class TraileViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater
        .from(parent.context)
        .inflate(R.layout.trailer_item, parent, false)
) {
    fun bind(trailer:Trailer){

    }
}