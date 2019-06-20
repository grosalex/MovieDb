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
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)
    }

    fun openDetail(context: Context, movie: Movie){
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DETAIL_KEY, Gson().toJson(movie))
        context.startActivity(intent)
    }

    const val PLAYER_KEY = "player_key"
    const val DETAIL_KEY = "detail_key"
}