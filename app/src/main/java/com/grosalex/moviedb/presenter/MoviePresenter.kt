package com.grosalex.moviedb.presenter

import com.grosalex.moviedb.contract.MoviesContract
import com.grosalex.moviedb.model.Movie

class MoviePresenter(val view:MoviesContract.View, val provider: MoviesContract.Provider):MoviesContract.Presenter, MoviesContract.Provider.OnMoviesFetched {

    override fun sendRequest() {
        view.loading()
        provider.getMovies(this)
    }

    override fun onSuccess(movies: ArrayList<Movie>) {
        view.bind(movies)
    }

    override fun onFailure(message: String) {
        view.onError(message)
    }
}