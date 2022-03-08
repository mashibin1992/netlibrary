package com.example.myapplication.net.demo.response

interface INetworkBaseResponse {

    fun isSucceeded(): Boolean

    fun getErrorMessage(): String

    fun getErrorCode(): Int?
}
