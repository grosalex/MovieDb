package com.grosalex.moviedb.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.grosalex.moviedb.Navigator
import com.grosalex.moviedb.R
import com.grosalex.moviedb.api.MovieService
import com.grosalex.moviedb.model.Movie
import com.squareup.picasso.Picasso


class DetailActivity : AppCompatActivity() {

    lateinit var ivPoster: ImageView
    lateinit var tvTitle: TextView
    lateinit var tvOverview: TextView
    lateinit var rvTrailers: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val detail = intent.getStringExtra(Navigator.DETAIL_KEY) ?: return
        val movie = Gson().fromJson(detail, Movie::class.java)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_white_24)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initView()
        bindMovie(movie)
    }

    private fun bindMovie(movie: Movie) {
        Picasso.get().load(MovieService.IMAGE_ROOT + movie.backdropUrl).into(ivPoster)
        tvTitle.text = movie.title
        tvOverview.text = movie.overview
    }

    private fun initView() {
        ivPoster = findViewById(R.id.iv_poster)
        tvTitle = findViewById(R.id.tv_title)
        tvOverview = findViewById(R.id.tv_overview)
        rvTrailers = findViewById(R.id.rv_trailers)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}