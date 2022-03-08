package com.example.myapplication.net.demo

import androidx.annotation.Keep
import com.example.myapplication.net.demo.response.BaseResponse
import com.example.myapplication.net.demo.response.IgnoreMessage
import com.example.myapplication.net.demo.response.ListInterface

@Keep
data class ListDataResponse(val data: List<ProductData> = listOf()) :
    BaseResponse(), ListInterface<ProductData>, IgnoreMessage {

    override fun getRespList(): List<ProductData> {
        return data
    }

    override fun getNextIndex(): Int {
        return 1
    }
}
