package com.grosalex.moviedb.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.grosalex.moviedb.R

class ListActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
    }
}