package com.grosalex.moviedb

import android.app.Application
import com.grosalex.moviedb.api.MovieService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieDbApp:Application() {
    lateinit var service: MovieService

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl(MovieService.ROOT)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create<MovieService>(MovieService::class.java)
        app = this
    }
    companion object {
        lateinit var app: MovieDbApp

        fun get(): MovieDbApp {
            return app
        }
    }
}