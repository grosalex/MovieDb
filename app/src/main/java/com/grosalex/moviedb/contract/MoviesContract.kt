package com.grosalex.moviedb.contract

import com.grosalex.moviedb.model.Movie

interface MoviesContract {

    interface View {
        fun loading()
        fun onError(message: String)
        fun bind(movies: ArrayList<Movie>)
    }

    interface Presenter {
        fun sendRequest()
    }

    interface Provider {
        interface OnMoviesFetched {
            fun onSuccess(movies: ArrayList<Movie>)
            fun onFailure(message: String)
        }

        fun getMovies(onMoviesFetched: OnMoviesFetched)
    }
}