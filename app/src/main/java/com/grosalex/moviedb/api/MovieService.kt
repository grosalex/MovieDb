package com.grosalex.moviedb.api

import com.grosalex.moviedb.response.MoviesResponse
import com.grosalex.moviedb.response.TrailersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface MovieService {

    @GET("discover/movie${API_KEY}")
    fun discoverMovies(): Call<MoviesResponse>

    @GET("movie/{movie_id}/videos${API_KEY}")
    fun getMovieTrailers(@Path("movie_id") movieId: Int): Call<TrailersResponse>

    companion object {
        const val API_KEY = "?api_key=824ae86d1ad39fe857eef96b86a6ffd4"
        const val ROOT = "https://api.themoviedb.org/3/"
        const val IMAGE_ROOT = "https://image.tmdb.org/t/p/w500"
    }
}