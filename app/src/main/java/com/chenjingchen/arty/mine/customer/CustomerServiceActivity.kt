package com.chenjingchen.arty.mine.customer

import com.chenjingchen.arty.R
import com.chenjingchen.arty.base.BaseActivity
import com.gyf.immersionbar.ImmersionBar

class CustomerServiceActivity(override var layout: Int = R.layout.activity_customer_service) : BaseActivity() {
  private lateinit var immersionBar:ImmersionBar
  override fun initView() {
    immersionBar = ImmersionBar.with(this)
    immersionBar.init()
  }

  override fun onDestroy() {
    super.onDestroy()
    immersionBar.removeSupportAllView()
  }
}