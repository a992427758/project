package com.chenjingchen.arty

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.view.View
import com.chenjingchen.arty.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity(override var layout: Int = R.layout.activity_splash) : BaseActivity() , View.OnClickListener {
  private var handler = @SuppressLint("HandlerLeak")
  object : Handler() {
    override fun handleMessage(msg: Message) {
      textTime--
      if (msg.what!= 0){
        skip.text = "跳过 | ${textTime}S"
        val msg = Message.obtain()
        msg.what = textTime
        sendMessageDelayed(msg,1000)
      }else if (msg.what == 0){
        showMain()
      }
      super.handleMessage(msg)
    }
  }
  private var textTime = 3
  override fun initView() {
    show()
    skip.setOnClickListener(this)
  }

  override fun onClick(v: View?) {
    when (v?.id){
      R.id.skip -> {
        showMain()
        handler.removeCallbacksAndMessages(null)
      }
    }
  }

  private fun show(){
    val msg = Message.obtain()
    msg.what = textTime
    handler.sendMessageDelayed(msg,1000)
  }

  fun showMain(){
    val mainIntent = Intent(this,MainActivity::class.java)
    startActivity(mainIntent)
    finish()
  }

  override fun onDestroy() {
    super.onDestroy()
    handler.removeCallbacksAndMessages(null)
  }
}