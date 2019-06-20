package com.grosalex.moviedb.youtube

import com.google.android.youtube.player.YouTubePlayer

object YoutubeManager {

    private var youTubePlayer: YouTubePlayer? = null

    const val YOUTUBE_API_KEY = "AIzaSyAjPZAV1hH4OxRLYfPICcF9bsyf8OcBjyw"

    fun changePlayer(newYouTubePlayer: YouTubePlayer) {

        youTubePlayer?.release()
        youTubePlayer = newYouTubePlayer
    }

    fun playVideo(id: String) {
        youTubePlayer?.cueVideo(id)
    }

    fun releaseCurrentPlayer() {
        youTubePlayer?.release()
    }
}