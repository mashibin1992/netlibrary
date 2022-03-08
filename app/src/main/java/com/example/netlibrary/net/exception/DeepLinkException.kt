package com.jd.b.lib.net.http.exception

import java.lang.Exception

/**
 * DeepLink异常
 */
class DeepLinkException : Throwable() {

    var deepLinkString = ""

    var exception: Exception? = null

    override fun toString(): String {
        return "DeepLinkException(deepLinkString='$deepLinkString', exception=$exception)"
    }


}