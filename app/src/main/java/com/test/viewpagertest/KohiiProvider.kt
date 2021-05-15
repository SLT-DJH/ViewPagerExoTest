package com.test.viewpagertest

import android.content.Context
import com.google.android.exoplayer2.DefaultLoadControl
import kohii.v1.exoplayer.ExoPlayerConfig
import kohii.v1.exoplayer.Kohii
import kohii.v1.exoplayer.createKohii
import kohii.v1.utils.Capsule

object KohiiProvider {
    private val capsule = Capsule<Kohii, Context>(creator = { context ->
        createKohii(
            context.applicationContext, ExoPlayerConfig.FAST_START
        )
    })

    fun get(context: Context) = capsule.get(context)
}