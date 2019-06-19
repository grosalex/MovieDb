package com.grosalex.moviedb.presenter

import com.grosalex.moviedb.contract.TrailerContract
import com.grosalex.moviedb.model.Movie
import com.grosalex.moviedb.model.Trailer

/**
 * @author abruneau
 *         Created on 2019-06-19
 */
class TrailerPresenter(val view: TrailerContract.View, val provider: TrailerContract.Provider) :
    TrailerContract.Presenter, TrailerContract.Provider.OnTrailerFetched {

    override fun sendRequest(movie: Movie) {
        view.loading()
        provider.getTrailers(this, movie)
    }

    override fun onSuccess(trailers: ArrayList<Trailer>) {
        view.bind(trailers)
    }

    override fun onFailure(message: String) {
        view.onError(message)
    }
}