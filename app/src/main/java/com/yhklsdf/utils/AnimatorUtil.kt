package com.yhklsdf.utils

import android.support.v4.view.animation.LinearOutSlowInInterpolator
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AccelerateInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.DecelerateInterpolator

object AnimatorUtil {

    private val accelerateDecelerateInterpolator : AccelerateDecelerateInterpolator by lazy {
        AccelerateDecelerateInterpolator()
    }

    private val accelerateInterpolator : AccelerateInterpolator by lazy {
        AccelerateInterpolator()
    }

    private val decelerateInterpolator : DecelerateInterpolator by lazy {
        DecelerateInterpolator()
    }

    private val bounceInterpolator : BounceInterpolator by lazy {
        BounceInterpolator()
    }

    private val linearOutSlowInInterpolator : LinearOutSlowInInterpolator by lazy {
        LinearOutSlowInInterpolator()
    }


}