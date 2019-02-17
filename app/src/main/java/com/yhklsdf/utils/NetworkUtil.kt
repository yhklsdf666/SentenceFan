package com.yhklsdf.utils

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtil {
    companion object {
        private val TIME_OUT = 3000

        fun isNetworkAvailable(context: Context) : Boolean{
            val manager = context.applicationContext.getSystemService(
                    Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = manager.activeNetworkInfo
            return !(!info.isAvailable || info == null)
        }

        fun isNetworkConnect(context: Context): Boolean {
            val manager = context.applicationContext.getSystemService(
                    Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = manager.activeNetworkInfo
            return !(!info.isConnected|| info == null)
        }

        fun isWifi(context: Context): Boolean {
            val connectivityManager = context
                    .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetInfo = connectivityManager.activeNetworkInfo
            return activeNetInfo != null && activeNetInfo.type == ConnectivityManager.TYPE_WIFI
        }
    }
}