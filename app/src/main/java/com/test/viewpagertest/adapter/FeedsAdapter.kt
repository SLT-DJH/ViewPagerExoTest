package com.test.viewpagertest.adapter

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.PlayerView
import com.test.viewpagertest.R
import com.test.viewpagertest.adapter.item.FeedItem
import com.test.viewpagertest.adapter.viewholder.FeedViewHolder
import kohii.v1.core.Common
import kohii.v1.core.Playback
import kohii.v1.core.controller
import kohii.v1.exoplayer.Kohii

class FeedsAdapter(
    private val feedItems : ArrayList<FeedItem>,
    private val context : Context,
    private val kohii : Kohii
) : RecyclerView.Adapter<FeedViewHolder>() {

    private val TAG = "FeedsAdapter"

    private val holderList : HashMap<Int, FeedViewHolder> = HashMap()

    fun getItem(position: Int) : FeedItem {
        return feedItems[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        return FeedViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_feed, parent, false))
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val feedItem = feedItems[position]
        feedItem.position = position

        val playerView : PlayerView = holder.feedPlayerView
        playerView.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_ZOOM

        kohii.setUp(Uri.parse("https://dev-s.s3.ap-northeast-2.amazonaws.com/${feedItem.videoPath}")) {
            preload = true
            repeatMode = Common.REPEAT_MODE_ONE
            controller = controller(kohiiCanPause = true, kohiiCanStart = true) { playback, _ ->
                val playable = playback.playable ?: return@controller
                holder.feedContainer.setOnClickListener {
                    if(playable.isPlaying()) playback.manager.pause(playable)
                    else playback.manager.play(playable)
                }
            }
        }.bind(playerView)
    }

    override fun getItemCount(): Int {
        return feedItems.size
    }
}