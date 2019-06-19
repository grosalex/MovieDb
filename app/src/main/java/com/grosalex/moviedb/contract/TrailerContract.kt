package com.grosalex.moviedb.contract

import com.grosalex.moviedb.model.Movie
import com.grosalex.moviedb.model.Trailer

interface TrailerContract {

    interface View {
        fun loading()
        fun bind(trailers: ArrayList<Trailer>)
        fun onError(message: String)
    }

    interface Presenter {
        fun sendRequest(movie: Movie)
    }

    interface Provider {
        interface OnTrailerFetched {
            fun onSuccess(trailers: ArrayList<Trailer>)
            fun onFailure(message: String)
        }

        fun getTrailers(onTrailerFetched: OnTrailerFetched, movie: Movie)
    }
}