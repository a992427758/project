package com.chenjingchen.arty.http

import com.chenjingchen.arty.video.bean.VideoBean
import com.chenjingchen.arty.video.bean.VideoDataBean
import com.chenjingchen.arty.video.bean.VideoDatasBean
import com.chenjingchen.arty.video.bean.VideoListBean
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface RestApi {
  @GET("/article/list/2/json")
  fun getVideoModel(): Observable<VideoListBean<VideoDataBean<VideoDatasBean>>>?

  @GET("/api/v2/data/category/Girl/type/Girl/page/1/count/100")
  fun getViewPic(): Observable<VideoListBean<VideoBean>>
}