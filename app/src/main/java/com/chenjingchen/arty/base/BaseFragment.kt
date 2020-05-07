package com.chenjingchen.arty.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
  var mContext: Context? = null
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    mContext = activity
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return initView(inflater, container, savedInstanceState)
  }

  abstract fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
}