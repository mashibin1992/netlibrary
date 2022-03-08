package com.example.netlibrary.deeplink

import android.app.Activity
import android.content.Context
import com.google.gson.Gson

abstract class Linker<P : BaseParams>(val paramsString: String) {

    var p: P? = null

    var link = ""

    fun parseParams(gson: Gson) {
        p = gson.fromJson(paramsString, clazz())
    }

    fun finish(context: Context) {
        p?.let { params ->
            if (params.close == 1) {
//                "finish web container when close is 1".logv()
                if (context is Activity) {
                    context.finish()
                }
            }
        }
    }

    abstract fun route(context: Context)

    abstract fun clazz(): Class<P>
}