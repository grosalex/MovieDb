package com.grosalex.moviedb.provider

import com.grosalex.moviedb.MovieDbApp
import com.grosalex.moviedb.api.ApiCallback
import com.grosalex.moviedb.contract.TrailerContract
import com.grosalex.moviedb.model.Movie
import com.grosalex.moviedb.response.TrailersResponse

/**
 * @author abruneau
 *         Created on 2019-06-19
 */
class TrailerProvider : TrailerContract.Provider {
    override fun getTrailers(onTrailerFetched: TrailerContract.Provider.OnTrailerFetched, movie: Movie) {
        MovieDbApp.get().service.getMovieTrailers(movie.id).enqueue(object : ApiCallback<TrailersResponse>() {
            override fun onAnyError(error: String) {
                onTrailerFetched.onFailure(error)
            }

            override fun onSuccess(body: TrailersResponse?) {
                body?.trailers?.let { onTrailerFetched.onSuccess(it) }
            }
        })
    }
}