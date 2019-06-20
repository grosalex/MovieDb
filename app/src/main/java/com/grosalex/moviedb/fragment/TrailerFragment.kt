package com.grosalex.moviedb.fragment

import androidx.fragment.app.Fragment
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import com.grosalex.moviedb.Navigator
import com.grosalex.moviedb.youtube.YoutubeManager

class TrailerFragment : YouTubePlayerSupportFragment(),
    YouTubePlayer.OnInitializedListener {

    override fun onInitializationSuccess(
        provider: YouTubePlayer.Provider?,
        youTubePlayer: YouTubePlayer?,
        wasRestored: Boolean) {

        if (youTubePlayer != null) {
            YoutubeManager.changePlayer(youTubePlayer)
            val key = (this as Fragment).arguments?.getString(Navigator.PLAYER_KEY)
            if (key != null) {
                YoutubeManager.playVideo(key)
            }
        }
    }

    override fun onInitializationFailure(
        provider: YouTubePlayer.Provider?,
        youTubePlayer: YouTubeInitializationResult?) { }

    fun initialize() {
        initialize(YoutubeManager.YOUTUBE_API_KEY, this)
    }
}