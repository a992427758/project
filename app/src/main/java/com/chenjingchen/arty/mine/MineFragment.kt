package com.chenjingchen.arty.mine

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chenjingchen.arty.mine.customer.CustomerServiceActivity
import com.chenjingchen.arty.R
import com.chenjingchen.arty.mine.setting.SettingActivity
import com.chenjingchen.arty.mine.transaction.TransactionRecordActivity
import com.chenjingchen.arty.base.BaseFragment
import com.chenjingchen.arty.bean.MineListBean
import com.chenjingchen.arty.mine.adapter.MineAdapter

class MineFragment : BaseFragment() {

  private lateinit var recyclerView: RecyclerView
  private lateinit var mView: View
  private var mList = mutableListOf<MineListBean>()
  private var adapter = MineAdapter(mList)

  override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
    mView = inflater.inflate(R.layout.activity_mine, container, false)
    if (mList.size == 0) {
      getData()
    }
    recyclerView = mView.findViewById(R.id.recycleView)
    recyclerView.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
    recyclerView.adapter = adapter
    adapter.setOnItemClickListener(object : MineAdapter.OnItemClickListener {
      override fun onItemClick(position: Int, data: MineListBean?) {

      }

      override fun onItemChange(position: Int) {
        if (position == 1){
          val intent = Intent(context, TransactionRecordActivity::class.java)
          startActivity(intent)
        }else if (position == 2){
          val intent = Intent(context, CustomerServiceActivity::class.java)
          startActivity(intent)
        }else if (position == 3){
          val intent = Intent(context, SettingActivity::class.java)
          startActivity(intent)
        }
      }
    })
    adapter.notifyDataSetChanged()
    return mView
  }

  private fun getData() {
    val transactionRecord = MineListBean()
    val setting = MineListBean()
    val customerService = MineListBean()
    transactionRecord.imageId = R.mipmap.transaction_record
    transactionRecord.text = "交易记录"
    setting.imageId = R.mipmap.setting
    setting.text = "设置"
    customerService.imageId = R.mipmap.customer_service
    customerService.text = "客服"
    mList.add(transactionRecord)
    mList.add(customerService)
    mList.add(setting)
  }

}