package com.example.myapplication.net

class Response<T>(
    val data: T?,
    val errorCode: Int,
    val errorMsg: String
)