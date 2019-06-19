package com.grosalex.moviedb

import android.content.Context
import android.content.Intent
import com.google.gson.Gson
import com.grosalex.moviedb.activity.DetailActivity
import com.grosalex.moviedb.activity.ListActivity
import com.grosalex.moviedb.model.Movie

object Navigator {
    fun openListActivity(context: Context){
        val intent = Intent(context, ListActivity::class.java)
        context.startActivity(intent)
    }

    fun openDetail(context: Context, movie: Movie){
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DETAIL_KEY, Gson().toJson(movie))
        context.startActivity(intent)
    }

    const val DETAIL_KEY = "detail_key"
}