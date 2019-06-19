package com.grosalex.moviedb.youtube

import com.google.android.youtube.player.YouTubePlayer

object YoutubeManager {
    const val YOUTUBE_API_KEY = "AIzaSyAjPZAV1hH4OxRLYfPICcF9bsyf8OcBjyw"

    private var youTubePlayer:YouTubePlayer? = null

    fun changePlayer(newYouTubePlayer: YouTubePlayer){

        youTubePlayer?.release()
        youTubePlayer = newYouTubePlayer
    }

    fun playVideo(id:String){
        youTubePlayer?.loadVideo(id)
    }
}