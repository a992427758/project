package com.chenjingchen.arty.home

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.chenjingchen.arty.R
import com.chenjingchen.arty.base.BaseFragment
import com.chenjingchen.arty.ui.MyImageLoader
import com.chenjingchen.arty.utils.ImageUtils
import kotlinx.android.synthetic.main.activity_home.*
import okhttp3.*
import java.io.IOException
import java.lang.ref.WeakReference

class HomeFragment :BaseFragment(),View.OnClickListener{
  companion object {
    var imageUrl = "https://ns-strategy.cdn.bcebos.com/ns-strategy/upload/fc_big_pic/part-00317-3814.jpg"
    var imageUrl1 = "http://img2.imgtn.bdimg.com/it/u=1101519187,4188141197&fm=26&gp=0.jpg"
    const val SUCCESS = 0x0001
    const val FAIL = 0x0002
    lateinit var mImageView: ImageView
    var mImageLoader = MyImageLoader()
  }
  lateinit var mHandler:MyHandler


  override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    val view = inflater.inflate(R.layout.activity_home,container,false)
    mHandler = MyHandler(this)
    mImageView = view.findViewById(R.id.iv_lruCache)
    view.findViewById<Button>(R.id.bt_load).setOnClickListener(this)
    showPicture()
    return view
  }
  //默认就是 java的 public static
  class  MyHandler(fragment: BaseFragment) : Handler() {
    private var mWeakReference: WeakReference<BaseFragment> = WeakReference(fragment)
    override fun handleMessage(msg: Message) {
      val fragment = mWeakReference.get()
      if (fragment != null){
        if (msg.what == SUCCESS){
          val picture = msg.obj as ByteArray
          val bitmap = BitmapFactory.decodeByteArray(picture,0,picture.size)
          mImageLoader.addBitmap(imageUrl,bitmap)
          mImageView.setImageBitmap(bitmap)
        }
      }
    }
  }

  private fun getBitmapFromCache():Bitmap?{
    return mImageLoader.getBitmap(imageUrl)
  }

  private fun downLoadBitmap(){
    val okHttpClient = OkHttpClient()
    val request = Request.Builder()
      .url(imageUrl)
      .build()
    val call = okHttpClient.newCall(request)
    call.enqueue(object:Callback{
      override fun onFailure(call: Call, e: IOException) {

      }

      override fun onResponse(call: Call, response: Response) {
        val pictures:ByteArray =  response.body!!.bytes()
        val message = mHandler.obtainMessage()
        message.obj = pictures
        message.what = SUCCESS
        mHandler.sendMessage(message)
      }
    })
  }

  override fun onClick(v: View?) {
    when(v?.id){
      R.id.bt_load -> {

      }
    }
  }
  fun showPicture(){
    val bitmap:Bitmap? = getBitmapFromCache()
    if (bitmap != null){
      Log.e("111","从缓存中取图片出来")
      mImageView.setImageBitmap(bitmap)
    }else {
      Log.e("111","从网络下载图片")
      downLoadBitmap()
    }
  }

  override fun onDestroy() {
    super.onDestroy()
    mHandler.removeCallbacksAndMessages(null)
  }
}