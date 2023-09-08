package com.example.unify_task_sandeep_kumar.di

import android.content.Context
import com.example.unify_task_sandeep_kumar.utils.Utils
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject

class ConnectivityInterceptor @Inject constructor(private var context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!Utils.isNetworkAvailable(context)) {
            throw NoConnectivityException()
        }

        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

    private class NoConnectivityException : IOException() {

        override val message: String
            get() = "Please check network connectivity."
    }
}