package com.chenjingchen.arty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import com.chenjingchen.arty.base.BaseActivity
import com.chenjingchen.arty.home.HomeFragment
import com.chenjingchen.arty.menber.MemberFragment
import com.chenjingchen.arty.mine.MineFragment
import com.chenjingchen.arty.video.VideoFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity(override var layout: Int = R.layout.activity_main) :BaseActivity(), RadioGroup.OnCheckedChangeListener {
  private var homeFragment:HomeFragment? = HomeFragment()
  private var videoFragment:VideoFragment? = VideoFragment()
  private var memberFragment:MemberFragment? = MemberFragment()
  private var mineFragment:MineFragment? = MineFragment()

  override fun initView() {
    radio_group.setOnCheckedChangeListener(this)
    radio_group.check(R.id.home_btn)
  }

  override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
    var transaction = supportFragmentManager.beginTransaction()
    when(checkedId){
      R.id.home_btn -> {
        if (homeFragment == null){
          homeFragment = HomeFragment()
        }
        transaction.replace(R.id.frame_layout,homeFragment!!)
      }
      R.id.video_btn -> {
        if (videoFragment == null){
          videoFragment = VideoFragment()
        }
        transaction.replace(R.id.frame_layout,videoFragment!!)
      }
      R.id.member_btn -> {
        if (memberFragment == null){
          memberFragment = MemberFragment()
        }
        transaction.replace(R.id.frame_layout,memberFragment!!)
      }
      R.id.mine_btn -> {
        if (mineFragment == null){
          mineFragment = MineFragment()
        }
        transaction.replace(R.id.frame_layout,mineFragment!!)
      }
    }
    transaction.commit()
  }
}
