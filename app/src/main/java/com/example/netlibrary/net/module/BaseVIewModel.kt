package com.example.myapplication.net.module

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.net.RetrofitManger
import com.example.myapplication.net.bean.ArticleBean
import com.example.myapplication.net.bean.DataX
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class BaseVIewModel : ViewModel() {

    private val api by lazy { RetrofitManger.getApiService() }

    private var _homePageInfo: MutableLiveData<List<DataX>> = MutableLiveData()
    var apiError: MutableLiveData<Throwable> = MutableLiveData()

    fun getArticles(page: Int): LiveData<List<DataX>> {

        val homePageInfo: MutableLiveData<List<DataX>> = MutableLiveData()
        val exception = CoroutineExceptionHandler { coroutineContext, throwable ->
            apiError.postValue(throwable)
            Log.i("CoroutinesViewModel", throwable.message!!)
        }

        viewModelScope.launch(exception) {
            val respose = api.getArticleList(page)
            if (respose.errorCode == 0) {
                homePageInfo.postValue(respose.data?.datas)
            } else {
                homePageInfo.postValue(mutableListOf())
            }
        }
        return homePageInfo
    }
}