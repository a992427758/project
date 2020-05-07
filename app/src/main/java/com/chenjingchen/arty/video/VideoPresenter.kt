package com.chenjingchen.arty.video

import android.annotation.SuppressLint
import android.util.Log
import com.chenjingchen.arty.video.bean.VideoBean
import com.chenjingchen.arty.video.bean.VideoDataBean
import com.chenjingchen.arty.video.bean.VideoDatasBean
import com.chenjingchen.arty.video.bean.VideoListBean
import io.reactivex.observers.DisposableObserver

class VideoPresenter {
  private val videoModel:VideoModel = VideoModel()
  private lateinit var view:VideoFragment
  @SuppressLint("CheckResult")
  fun  getData(){
    videoModel.videoModel()?.subscribeWith(object : DisposableObserver<VideoListBean<VideoBean>>(){
      override fun onComplete() {

      }

      override fun onNext(t: VideoListBean<VideoBean>) {
        Log.e("111","成功")
        view.showData(t)
      }

      override fun onError(e: Throwable) {
        Log.e("111",e.toString())
      }

    })
  }

  fun attachView(view:VideoFragment){
    this.view = view
  }
}