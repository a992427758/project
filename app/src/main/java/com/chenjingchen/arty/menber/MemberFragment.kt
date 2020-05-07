package com.chenjingchen.arty.menber

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chenjingchen.arty.R
import com.chenjingchen.arty.base.BaseFragment

class MemberFragment :BaseFragment() {
  override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    return inflater.inflate(R.layout.activity_member,container,false)
  }
}