package com.grosalex.moviedb

import android.content.Context
import android.content.Intent
import com.grosalex.moviedb.activity.ListActivity

object Navigator {
    fun openListActivity(context: Context){
        val intent = Intent(context, ListActivity::class.java)
        context.startActivity(intent)
    }
}