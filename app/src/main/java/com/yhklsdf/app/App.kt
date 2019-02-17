package com.yhklsdf.app

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDexApplication
import org.litepal.LitePal
import kotlin.properties.Delegates

class App : MultiDexApplication() {

    companion object {
        private val TAG = "App"

        //延迟初始化的非空属性，避免使用不必要的 !! 操作符（使用Delegates.notNull()的属性必须是var）
        var context : Context by Delegates.notNull()
            private set

        lateinit var instance : Application
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        context = applicationContext
        initTheme()
        initLitePal()
    }

    private fun initLitePal() {
        LitePal.initialize(this)
    }

    private fun initTheme() {

    }
}