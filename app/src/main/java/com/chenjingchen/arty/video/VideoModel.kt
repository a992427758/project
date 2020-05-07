package com.chenjingchen.arty.video

import com.chenjingchen.arty.http.Http
import com.chenjingchen.arty.video.bean.VideoBean
import com.chenjingchen.arty.video.bean.VideoDataBean
import com.chenjingchen.arty.video.bean.VideoDatasBean
import com.chenjingchen.arty.video.bean.VideoListBean
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class VideoModel {
  fun videoModel(): Observable<VideoListBean<VideoBean>>? {
    return Http.getInstance()?.getRestApi()?.getViewPic()?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
  }

}