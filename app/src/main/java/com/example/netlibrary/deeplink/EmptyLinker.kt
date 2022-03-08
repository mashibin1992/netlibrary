package com.example.netlibrary.deeplink

import android.content.Context

/**
 * 空的跳转配置，不做任何跳转动作
 */
class EmptyLinker() : Linker<BaseParams>("") {

    override fun route(context: Context) {
        //do nothind
    }

    override fun clazz(): Class<BaseParams> {
        return BaseParams::class.java
    }

}