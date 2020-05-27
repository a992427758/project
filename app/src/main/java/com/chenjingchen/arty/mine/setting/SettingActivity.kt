package com.chenjingchen.arty.mine.setting

import android.view.View
import android.widget.Toast
import com.chenjingchen.arty.R
import com.chenjingchen.arty.base.BaseActivity
import com.chenjingchen.arty.utils.AESUtils
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity(override var layout: Int = R.layout.activity_setting) : BaseActivity(),View.OnClickListener {

  private var PASSWORD_STRING = "12345678"
  private var aes = AESUtils()

  override fun initView() {
    encrypt.setOnClickListener(this)
    decrypt.setOnClickListener(this)
  }
  //加密
  private fun encrypt(){
    var inputString:String? = ase_input.text.toString().trim()
    if (inputString?.length == 0){
      Toast.makeText(this,"请输入加密的内容",Toast.LENGTH_LONG).show()
      return
    }
    var encryStr = aes.encrypt(PASSWORD_STRING,inputString?:"")
    show_ase_encrypt.text = encryStr
  }

  //解密
  private fun decrypt(){
    var inputString:String? = show_ase_encrypt.text.toString().trim()
    if (inputString?.length == 0){
      Toast.makeText(this,"请输入加密的内容",Toast.LENGTH_LONG).show()
      return
    }
    var decryStr = aes.decrypt(PASSWORD_STRING,inputString?:"")
    show_oringe_encrypt.text = decryStr
  }

  override fun onClick(v: View?) {
    when(v?.id){
      R.id.encrypt -> encrypt()
      R.id.decrypt -> decrypt()
    }
  }
}