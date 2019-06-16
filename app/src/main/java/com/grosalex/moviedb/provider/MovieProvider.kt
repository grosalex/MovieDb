package com.grosalex.moviedb.provider

import com.grosalex.moviedb.MovieDbApp
import com.grosalex.moviedb.api.ApiCallback
import com.grosalex.moviedb.contract.MoviesContract
import com.grosalex.moviedb.response.MoviesResponse

class MovieProvider : MoviesContract.Provider {
    override fun getMovies(onMoviesFetched: MoviesContract.Provider.OnMoviesFetched) {
        MovieDbApp.get().service.discoverMovies().enqueue(object : ApiCallback<MoviesResponse>() {
            override fun onSuccess(body: MoviesResponse?) {
                if (body != null)
                    onMoviesFetched.onSucces(body.results)
            }

            override fun onAnyError(error: String) {
                onMoviesFetched.onFailure(error)
            }
        })
    }
}