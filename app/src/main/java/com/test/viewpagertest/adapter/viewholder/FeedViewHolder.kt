package com.test.viewpagertest.adapter.viewholder

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.VideoView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.hls.DefaultHlsDataSourceFactory
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelection
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder
import com.google.android.exoplayer2.upstream.*
import com.google.android.exoplayer2.util.Util
import com.test.viewpagertest.R
import com.test.viewpagertest.adapter.item.FeedItem
import java.lang.IllegalStateException

class FeedViewHolder(
    private val view : View
) : RecyclerView.ViewHolder(view) {

//    val videoPlayer : SimpleExoPlayer = SimpleExoPlayer.Builder(context).build()
    val feedPlayerView: PlayerView = view.findViewById(R.id.feedPlayerView)
    val playButton : ImageView = view.findViewById(R.id.iv_play_button)
    val feedContainer : ConstraintLayout = view.findViewById(R.id.feedContainer)
//    private val videoProgressBar = view.findViewById<ProgressBar>(R.id.feedVideoProgressBar)
//    private val playImageView = view.findViewById<ImageView>(R.id.iv_play_button)

//    var TAG = "FeedViewHolder"
//
//    private var touchedVideoView : Boolean = false
//
//    fun bind(feedItem : FeedItem) {
//        initPlayerView()
//        setData(feedItem)
//    }
//
//    private fun initPlayerView() {
//
//        feedPlayerView.useController = false
//        feedPlayerView.player = videoPlayer
//        feedPlayerView.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM
//
//    }
//
//    private fun setData(feedItem: FeedItem){
//        Log.d(TAG, "setData")
//        val videoUri = Uri.parse("https://dev-s.s3.ap-northeast-2.amazonaws.com/${feedItem.videoPath}")
//
//        val mediaItem = MediaItem.fromUri(videoUri)
//
//        videoPlayer.setMediaItem(mediaItem)
//
//        videoPlayer.prepare()
//
//        videoPlayer.addListener(object : Player.EventListener{
//            override fun onPlayerStateChanged(playWhenReady: Boolean, playbackState: Int) {
//                when(playbackState){
//                    Player.STATE_BUFFERING -> {
//                    }
//                    // STATE IDLE -> 재생실패
//                    // STATE BUFFERING -> 재생준비
//                    // STATE READY -> 재생 준비 완료
//                    // STATE ENDED -> 재생 마침
//                    Player.STATE_READY -> {
//
//                    }
//                    Player.STATE_ENDED -> {
//                        videoPlayer.seekTo(0)
//                        videoPlayer.playWhenReady = true
//                    }
//                }
//            }
//        })


//        videoView.setVideoURI(videoUri)
//
//        videoView.setOnPreparedListener { mediaPlayer ->
//            hideLoading()
//
//            mediaPlayer.start()
//
//            fixVideoSize(mediaPlayer, videoView)
//
//            videoView.setOnTouchListener { _, _ ->
//                if(!touchedVideoView) {
//                    touchedVideoView = true
//
//                    try {
//                        if(mediaPlayer.isPlaying){
//                            mediaPlayer.pause()
//                        } else {
//                            mediaPlayer.start()
//                        }
//                    } catch (e : IllegalStateException){
//
//                    }
//
//                    videoView.postDelayed({
//                        touchedVideoView = false
//                    }, 100)
//
//                    true
//                } else {
//                    false
//                }
//            }
//        }
    }



//    private fun fixVideoSize(player : MediaPlayer, videoView: VideoView){
//        val videoRatio : Float = player.videoWidth / player.videoHeight.toFloat()
//        val screenRatio : Float = videoView.width / videoView.height.toFloat()
//        val scale : Float = videoRatio / screenRatio
//        if (scale >= 1f){
//            videoView.scaleX = scale
//        } else {
//            videoView.scaleX = 1f / scale
//        }
//    }
//
//    fun showLoading() {
//        videoProgressBar.visibility = View.VISIBLE
//    }
//
//    fun hideLoading() {
//        videoProgressBar.visibility = View.INVISIBLE
//    }
//
//    fun showPlayButton() {
//        playImageView.visibility = View.VISIBLE
//    }
//
//    fun hidePlayButton() {
//        playImageView.visibility = View.INVISIBLE
//    }
//
//    fun playPlayer() {
//        videoPlayer.seekTo(0)
//        videoPlayer.playWhenReady = true
//    }
//
//    fun pausePlayer() {
//        videoPlayer.pause()
//    }
//
//    fun releasePlayer() {
//        videoPlayer.release()
//    }
//
//}