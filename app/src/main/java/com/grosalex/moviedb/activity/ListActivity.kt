package com.grosalex.moviedb.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.grosalex.moviedb.R
import com.grosalex.moviedb.adapter.MoviesAdapter
import com.grosalex.moviedb.contract.MoviesContract
import com.grosalex.moviedb.model.Movie
import com.grosalex.moviedb.presenter.MoviePresenter
import com.grosalex.moviedb.provider.MovieProvider

class ListActivity : AppCompatActivity(), MoviesContract.View {
    private lateinit var rvList: RecyclerView
    private lateinit var adapter: MoviesAdapter
    private lateinit var presenter: MoviePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        rvList = findViewById(R.id.rv_list)
        initRecyclerview()
        presenter = MoviePresenter(this, MovieProvider())
        presenter.sendRequest()
    }

    private fun initRecyclerview() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        rvList.layoutManager = layoutManager
        adapter = MoviesAdapter(ArrayList<Movie>())
        rvList.adapter = adapter
    }

    override fun loading() {
        adapter.movies.clear()
        adapter.notifyDataSetChanged()
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun bind(movies: ArrayList<Movie>) {
        adapter.movies.addAll(movies)
        adapter.notifyDataSetChanged()
    }
}