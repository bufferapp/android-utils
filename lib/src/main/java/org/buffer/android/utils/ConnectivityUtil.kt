package org.buffer.android.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager

object ConnectivityUtil {

    @SuppressLint("MissingPermission")
    fun checkConnectivity(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }
}