package com.test.viewpagertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelection
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.test.viewpagertest.adapter.FeedsAdapter
import com.test.viewpagertest.adapter.item.FeedItem
import kohii.v1.core.MemoryMode
import kohii.v1.exoplayer.Kohii
import kohii.v1.exoplayer.KohiiExoPlayer

class MainActivity : AppCompatActivity() {
    private lateinit var feedsAdapter : FeedsAdapter
    private lateinit var viewPager : ViewPager2
    private lateinit var swipeRefresh : SwipeRefreshLayout
    private lateinit var kohii : Kohii

    private var currentInit = false

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewpager2_feed)
        swipeRefresh = findViewById(R.id.swipe_refresh)

        kohii = KohiiProvider.get(applicationContext)
        kohii.register(this, memoryMode = MemoryMode.HIGH).addBucket(viewPager)


        if (!currentInit) {
            initViewPager()
            currentInit = true
        }

        swipeRefresh.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener{
            override fun onRefresh() {
                initViewPager()
                swipeRefresh.isRefreshing = false
            }
        })

//        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                Log.d(TAG, "viewpageron selected page : $position, ${feedsAdapter.getItem(position).videoPath}" +
//                        "${feedsAdapter.getHolderByPosition(position)!!.videoPlayer}")
//
//                feedsAdapter.getHolderByPosition(position)!!.playPlayer()
//
//                val nextPosition = position + 1
//                val previousPosition = position - 1
//                if (position == 0){
//                    feedsAdapter.getHolderByPosition(nextPosition)?.pausePlayer()
//                } else if (position == feedsAdapter.itemCount) {
//                    feedsAdapter.getHolderByPosition(previousPosition)?.pausePlayer()
//                } else {
//                    feedsAdapter.getHolderByPosition(nextPosition)?.pausePlayer()
//                    feedsAdapter.getHolderByPosition(previousPosition)?.pausePlayer()
//                }
//            }
//        })
        
    }

    private fun initViewPager() {

        feedsAdapter = FeedsAdapter(setData(), applicationContext, kohii)

        viewPager.adapter = feedsAdapter
        viewPager.offscreenPageLimit = 1

    }

    private fun setData() : ArrayList<FeedItem> {
        Log.d(TAG, "setData(), feedItem added")

        val feedItemList : ArrayList<FeedItem> = ArrayList()

        feedItemList.add(FeedItem("4dcc941cbfc8385c5c02de9b5c77fd0d.mp4"))
        feedItemList.add(FeedItem("a8af3d92a758bdef70a3d02a82ca4aa9.mp4"))
        feedItemList.add(FeedItem("917f68fb6f362d3a0bf8cbed5e517313.mp4"))
        feedItemList.add(FeedItem("6b052c41c6d531e8567c2b2e4e0a6de1.mp4"))
        feedItemList.add(FeedItem("7279d1980fa92902b11b92ab8c9a7a9e.mp4"))
        feedItemList.add(FeedItem("a746c32caeba1402db4c4ddf0cfe035c.mp4"))
        feedItemList.add(FeedItem("0322ea079a810aa9c92ecda86ca38638.mp4 "))
        feedItemList.add(FeedItem("6f5211125ca2e8e1fcc165ba6587f4f9.mp4"))

        return feedItemList
    }
}