package com.grosalex.moviedb.response

import com.google.gson.annotations.SerializedName
import com.grosalex.moviedb.model.Trailer

data class TrailersResponse(val id: Int?,
                            @SerializedName("results") val trailers: ArrayList<Trailer>?)