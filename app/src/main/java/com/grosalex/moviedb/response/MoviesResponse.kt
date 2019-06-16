package com.grosalex.moviedb.response

import com.google.gson.annotations.SerializedName
import com.grosalex.moviedb.model.Movie

data class MoviesResponse(
    val page: Int?,
    @SerializedName("total_results") val totalResult: Int?,
    @SerializedName("total_pages") val totalPage: Int?,
    val results: ArrayList<Movie>?
)