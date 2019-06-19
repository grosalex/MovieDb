package com.grosalex.moviedb.fragment

import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import com.grosalex.moviedb.youtube.YoutubeManager

class TrailerFragment(val key: String) : YouTubePlayerSupportFragment(),
    YouTubePlayer.OnInitializedListener {
    override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, p1: YouTubePlayer?, p2: Boolean) {
        if (p1 != null) {
            YoutubeManager.changePlayer(p1)
            YoutubeManager.playVideo(key)
        }
    }

    override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun initialize(){
        initialize(YoutubeManager.YOUTUBE_API_KEY, this)
    }
}