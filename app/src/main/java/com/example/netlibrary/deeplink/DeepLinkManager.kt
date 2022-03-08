//package com.example.netlibrary.deeplink
//
//import android.net.Uri
//import com.google.gson.Gson
//import java.net.URLDecoder
//import java.nio.charset.StandardCharsets
//
//object DeepLinkManager {
//
//    val gson = Gson()
//
//    val emptyLinker = EmptyLinker()
//
//    fun checkSchema(schema: String?): Boolean {
//        return schema == SCHEMA
//    }
//
//    fun parse(url: String?): Linker<*> {
//        if (url.isNullOrEmpty()) {
//            return emptyLinker
//        }
//        return try {
//            val uri = Uri.parse(url)
//            parse(uri)
//        } catch (e: Exception) {
//            //异常上报
////            CrashReporter.postCustomException(e, "DeepLinkManager")
//            emptyLinker
//        }
//    }
//
//    fun parse(uri: Uri?): Linker<*> {
//        try {
//            if (uri == null) {
////                "uri is null".logv()
//                return emptyLinker
//            }
////            "parse uri $uri".logv()
//            if (uri.scheme.equals("http", true) || uri.scheme.equals(
//                    "https",
//                    true
//                )
//            ) {//先处理http和https协议
////                "uri is start with http, so make Html5Linker".logv()
////                return Html5Linker("").apply {
////                    p = Html5Params(uri.toString())
////                }
//            }
//            if (uri.host != "jump") {
////                "host is not jump".logv()
//                return emptyLinker
//            }
//
//            if (!checkSchema(uri.scheme)) {
////                "uri is not permit schema".logv()
//                return emptyLinker
//            }
//            val paramsBegin = "params={"
//            val uriString = uri.toString()
//            val params = uriString.substring(
//                IntRange(
//                    uriString.indexOf(paramsBegin) + paramsBegin.length - 1,
//                    uriString.indexOf("}")
//                )
//            ).let {
//                if (!it.contains("http", true)) {
//                    URLDecoder.decode(it, StandardCharsets.UTF_8.name())
//                } else {
//                    it
//                }
//            }
//            if (params.isNullOrEmpty()) {
//                return emptyLinker
//            }
//            val baseParams = gson.fromJson(params, BaseParams::class.java)
////        if (baseParams.login == 1 && !LoginHelper.hasLogin()) {
////            return LoginLinker(params)
////        }
//            val linker = when (baseParams.des.lowercase()) {
//                "m".lowercase() -> {
////                    Html5Linker(params).apply {
////                        parseParams(gson)
////                    }
//                }
//                "main".lowercase() -> {
////                    MainTabLinker(params).apply {
////                        parseParams(gson)
////                    }
//                }
//                "productDetail".lowercase() -> {
////                    ProductDetailLinker(params).apply {
////                        parseParams(gson)
////                    }
//                }
//                "search".lowercase() -> {
////                    SearchLinker(params).apply {
////                        parseParams(gson)
////                    }
//                }
//                "productList".lowercase() -> {
////                    ProductListLinker(params).apply {
////                        parseParams(gson)
////                    }
//                }
//                "activity".lowercase() -> {
////                    ActivityLinker(params).apply {
////                        parseParams(gson)
////                    }
//                }
//                "couponBatch".lowercase() -> {
////                    CouponBatchLinker(params).apply {
////                        parseParams(gson)
////                    }
//                }
//                "orderList".lowercase() -> {
////                    OrderLinker(params).apply {
////                        parseParams(gson)
////                    }
//                }
//                "orderDetail".lowercase() -> {
////                    OrderLinker(params).apply {
////                        parseParams(gson)
////                    }
//                }
//                "login".lowercase() -> {
////                    LoginLinker("")
//                }
//                else -> {
//                    emptyLinker
//                }
//            }
////            if (linker !is MainTabLinker) {//明确只跳转首页的就不再处理link的问题
////                linker.link = uriString
////            }
////            return linker
//
//        } catch (e: Exception) {
//            //异常上报
////            CrashReporter.postCustomException(e, "DeepLinkManager")
//            return emptyLinker
//        }
//    }
//
//}