package com.chenjingchen.arty.ui

import android.graphics.Bitmap
import android.util.LruCache
import androidx.core.graphics.get

class MyImageLoader() {
  private var mLruCache: LruCache<String,Bitmap>

  init {
    val  maxMemory = Runtime.getRuntime().maxMemory().toInt()
    //设置最大缓存空间为运行时内存的 1/8
    val cacheSize = maxMemory/8
    mLruCache = object : LruCache<String,Bitmap>(cacheSize){
      override fun sizeOf(key: String?, value: Bitmap?): Int {
         return value?.byteCount!!
      }
    }
  }
  //添加图片到LruCache
  fun addBitmap(key:String?,bitmap: Bitmap?){
    if (key?.let { getBitmap(it) } == null){
      mLruCache.put(key,bitmap)
    }
  }

  //从缓存中获取图片
  fun getBitmap(key:String):Bitmap?{
    return mLruCache.get(key)
  }

  //从缓存中删除指定的 Bitmap
  fun removeBitmap(key:String){
    mLruCache.remove(key)
  }
}