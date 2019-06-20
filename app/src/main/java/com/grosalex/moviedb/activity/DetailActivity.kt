package com.grosalex.moviedb.activity

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.gson.Gson
import com.grosalex.moviedb.Navigator
import com.grosalex.moviedb.R
import com.grosalex.moviedb.adapter.TrailerPagerAdapter
import com.grosalex.moviedb.api.MovieService
import com.grosalex.moviedb.contract.TrailerContract
import com.grosalex.moviedb.fragment.TrailerFragment
import com.grosalex.moviedb.model.Movie
import com.grosalex.moviedb.model.Trailer
import com.grosalex.moviedb.presenter.TrailerPresenter
import com.grosalex.moviedb.provider.TrailerProvider
import com.grosalex.moviedb.youtube.YoutubeManager
import com.squareup.picasso.Picasso
import androidx.fragment.app.Fragment


class DetailActivity : AppCompatActivity(), TrailerContract.View {

    lateinit var ivPoster: ImageView
    lateinit var tvTitle: TextView
    lateinit var tvOverview: TextView
    lateinit var presenter: TrailerPresenter
    lateinit var viewPager: ViewPager
    lateinit var pagerAdapter: TrailerPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val detail = intent.getStringExtra(Navigator.DETAIL_KEY) ?: return
        val movie = Gson().fromJson(detail, Movie::class.java)

        initView()
        bindMovie(movie)

        presenter = TrailerPresenter(this, TrailerProvider())
        presenter.sendRequest(movie)
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

        val ivBack: ImageView = findViewById(R.id.iv_back)
        ivBack.setOnClickListener {
            onBackPressed()
        }

        initViewPager()
    }

    private fun initViewPager() {
        viewPager = findViewById(R.id.pager)
        pagerAdapter = TrailerPagerAdapter(supportFragmentManager)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                YoutubeManager.releaseCurrentPlayer()
                (pagerAdapter.getItem(position) as TrailerFragment).initialize()
            }
        })
        viewPager.adapter = pagerAdapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun loading() {
        pagerAdapter.pages.clear()
        viewPager.adapter?.notifyDataSetChanged()
    }

    override fun bind(trailers: ArrayList<Trailer>) {
        trailers.forEach { trailer ->
            val trailerFragment = TrailerFragment()
            val bundle = Bundle()
            bundle.putString(Navigator.PLAYER_KEY, trailer.key)
            (trailerFragment as Fragment).arguments = bundle
            pagerAdapter.pages.add(trailerFragment)
        }
        viewPager.adapter?.notifyDataSetChanged()
        viewPager.currentItem = DEFAULT_POSITION
        (pagerAdapter.getItem(DEFAULT_POSITION) as TrailerFragment).initialize()
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val DEFAULT_POSITION = 0
    }
}