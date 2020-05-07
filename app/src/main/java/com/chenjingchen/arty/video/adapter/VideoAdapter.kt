package com.chenjingchen.arty.video.adapter

import android.content.Context
import android.text.style.BulletSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chenjingchen.arty.R
import com.chenjingchen.arty.video.bean.VideoBean
import com.chenjingchen.arty.video.bean.VideoDataBean
import com.chenjingchen.arty.video.bean.VideoDatasBean
import com.chenjingchen.arty.video.bean.VideoListBean
import kotlinx.android.synthetic.main.video_item.view.*

class VideoAdapter(context: Context,t: VideoListBean<VideoBean>) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
  private var data = t
  private var mContext = context

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    return VideoItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.video_item,parent,false))
  }

  override fun getItemCount(): Int {
    return data.data?.size?:0
  }

  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    holder as VideoItemViewHolder
    holder.name.text = data.data?.get(position)?.author
    holder.desc.text = data.data?.get(position)?.createdAt
    Glide.with(mContext).load(data.data?.get(position)?.images?.get(0)).into(holder.pic)
  }

  class VideoItemViewHolder(item:View):RecyclerView.ViewHolder(item){
    var name:TextView = item.name
    var desc:TextView = item.desc
    var pic:ImageView = item.pic
  }
}