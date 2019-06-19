package com.grosalex.moviedb.provider

import com.grosalex.moviedb.contract.TrailerContract
import com.grosalex.moviedb.model.Movie

/**
 * @author abruneau
 *         Created on 2019-06-19
 */
class TrailerProvider : TrailerContract.Provider {
    override fun getTrailers(onTrailerFetched: TrailerContract.Provider.OnTrailerFetched, movie: Movie) {
    }
}