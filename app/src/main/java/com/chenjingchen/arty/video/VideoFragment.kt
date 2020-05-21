package com.chenjingchen.arty.video

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chenjingchen.arty.R
import com.chenjingchen.arty.base.BaseFragment
import com.chenjingchen.arty.video.adapter.VideoAdapter
import com.chenjingchen.arty.video.bean.VideoBean
import com.chenjingchen.arty.video.bean.VideoDataBean
import com.chenjingchen.arty.video.bean.VideoDatasBean
import com.chenjingchen.arty.video.bean.VideoListBean

class VideoFragment :BaseFragment() {
  private lateinit var mView: View
  private val mPresenter:VideoPresenter? = VideoPresenter()
  private lateinit var mRecyclerView:RecyclerView

  override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    mView = inflater.inflate(R.layout.activity_video,container,false)
    mPresenter?.attachView(this)
    mPresenter?.getData()
    return mView
  }

  fun showData(data: VideoListBean<VideoBean>){
    mRecyclerView = mView.findViewById(R.id.video_rv)
    var adapter = VideoAdapter(mContext!!,data)
    mRecyclerView.layoutManager = GridLayoutManager(mContext,2)
    mRecyclerView.adapter = adapter

  }
}