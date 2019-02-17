package com.yhklsdf.utils

import android.preference.PreferenceManager
import com.yhklsdf.app.App

object SettingUtil {
    private val setting = PreferenceManager.getDefaultSharedPreferences(App.context)

    /**
     * 获取是否开启无图模式
     */
    fun getIsNoPhotoMode(): Boolean {
        return setting.getBoolean("switch_noPhotoMode",false)
    }
}