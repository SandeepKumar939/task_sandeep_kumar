package com.example.unify_task_sandeep_kumar.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo


class Utils {
    companion object {
        fun isNetworkAvailable(mContext: Context): Boolean {
            val cm = mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
            return activeNetwork?.isConnectedOrConnecting == true
        }
    }
}