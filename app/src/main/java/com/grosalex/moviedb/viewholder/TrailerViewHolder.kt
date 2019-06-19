package com.grosalex.moviedb.viewholder

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView
import com.grosalex.moviedb.R
import com.grosalex.moviedb.model.Trailer
import com.grosalex.moviedb.youtube.YoutubeManager

class TrailerViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater
        .from(parent.context)
        .inflate(R.layout.trailer_item, parent, false)
) {

    private val tvTrailerTitle: TextView = itemView.findViewById(R.id.tv_trailer_title)
    private val youtubePlayerView: YouTubePlayerView = itemView.findViewById(R.id.youtube_player_view)

    fun bind(trailer: Trailer) {
        tvTrailerTitle.text = trailer.name

        itemView.setOnClickListener {
            startPlayer(trailer)
        }
        youtubePlayerView.setOnClickListener { startPlayer(trailer) }
    }

    private fun startPlayer(trailer: Trailer) {
        val onInitializedListener = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                provider: YouTubePlayer.Provider?,
                player: YouTubePlayer?,
                wasRestored: Boolean
            ) {
                player?.let {
                    it.setShowFullscreenButton(false)
                    YoutubeManager.changePlayer(it)
                    YoutubeManager.playVideo(trailer.key)
                }
            }

            override fun onInitializationFailure(
                provider: YouTubePlayer.Provider?,
                result: YouTubeInitializationResult?
            ) {
                Log.e(TAG, provider?.toString() + result?.toString())
                Toast.makeText(itemView.context, result?.toString(), Toast.LENGTH_SHORT).show()
            }
        }
        youtubePlayerView.initialize(YoutubeManager.YOUTUBE_API_KEY, onInitializedListener)
    }

    companion object {
        val TAG = TrailerViewHolder::class.java.name
    }
}
