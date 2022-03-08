package com.example.myapplication.net

import com.example.myapplication.net.bean.ArticleListBean
import retrofit2.http.GET
import retrofit2.http.Path

interface Apis {
    // 和协程联用
    @GET("article/list/{page}/json")
    suspend fun getArticleList(@Path("page") page: Int): Response<ArticleListBean>
}