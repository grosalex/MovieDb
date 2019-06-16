package com.grosalex.moviedb.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.grosalex.moviedb.Navigator
import com.grosalex.moviedb.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            Navigator.openListActivity(this)
        }, SPLASH_DURATION)
    }

    companion object {
        const val SPLASH_DURATION = 1000L
    }
}
