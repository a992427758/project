package com.chenjingchen.arty.http

import com.chenjingchen.arty.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Http {

  companion object{
    private var ourInstance: Http? = null
    private var gson: Gson? = null

    fun getInstance(): Http? {
      gson = GsonBuilder().create()
      if (ourInstance == null) {
        ourInstance = Http()
      }
      return ourInstance
    }
  }

  private var retrofit: Retrofit? = null
  private var restApi: RestApi? = null

  init {
    retrofit = Retrofit.Builder()
      // 设置url头  ：http:www.shianyunduan.com   BuildConfig.API_HOST_URL
      .baseUrl("https://gank.io")
      //设置返回类型为RXJava，或者回调
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      //设置返回数据类型
      .addConverterFactory(GsonConverterFactory.create(gson))
      //设置网络请求，默认httpclient
      .client(OkHttpClient())
      .build()
    this.restApi = retrofit!!.create(RestApi::class.java)
  }


  fun getRestApi(): RestApi? {
    return restApi
  }




}