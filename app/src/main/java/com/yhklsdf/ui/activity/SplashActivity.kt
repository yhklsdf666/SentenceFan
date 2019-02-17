package com.yhklsdf.ui.activity

import android.content.Intent
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import cn.bmob.v3.Bmob
import com.yhklsdf.R
import com.yhklsdf.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

    private var alphaAnimation : AlphaAnimation? = null

    override fun attachLayoutRes() = R.layout.activity_splash

    override fun useEventBus() = false

    override fun initData() {
        Bmob.initialize(this@SplashActivity, "ce5890084341fa53dfad52581077d553")
    }

    override fun initView() {
        alphaAnimation = AlphaAnimation(0.3F,1.0F)
        alphaAnimation?.run {
            duration = 2000
            setAnimationListener(object : Animation.AnimationListener{
                override fun onAnimationRepeat(animation: Animation?) {
                }

                override fun onAnimationEnd(animation: Animation?) {
                    jumpToMain()
                }

                override fun onAnimationStart(animation: Animation?) {
                }

            })
        }
        activity_splash.startAnimation(alphaAnimation)
    }

    private fun jumpToMain() {
        val intent = Intent(this@SplashActivity,MainActivity::class.java)
        startActivity(intent)
        finish()
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
    }

    override fun start() {
    }

}
