package com.chenjingchen.arty.utils

import java.lang.StringBuilder
import java.math.RoundingMode.valueOf
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class ImageUtils {
  companion object {
    fun hashKeyForCache(key:String):String{
      var cacheKey:String
      try {
        val mDigest = MessageDigest.getInstance("MD5")
        mDigest.update(key.toByteArray())
        cacheKey = bytesToHexString(mDigest.digest())
      }catch (e: NoSuchAlgorithmException){
        cacheKey = valueOf(key.hashCode()).toString()
      }
      return cacheKey
    }

    private fun bytesToHexString(bytes:ByteArray):String{
      val sb = StringBuilder()
      for (index in 0..bytes.size){
        var hex = Integer.toHexString(0xFF and bytes[index].toInt())
        if (hex.length == 1){
          sb.append('0')
        }
        sb.append(hex)
      }
      return sb.toString()
    }
  }


}