package com.chenjingchen.arty.mine.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chenjingchen.arty.R
import com.chenjingchen.arty.bean.MineListBean
import com.chenjingchen.arty.mine.MineFragment
import kotlinx.android.synthetic.main.mine_item.view.*

class MineAdapter(list:MutableList<MineListBean>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
  private val BALANCE = 0
  private val ITEM = 1
  private var type:Int = 0
  private var mList : MutableList<MineListBean> = list
  private lateinit var onItemClickListener: OnItemClickListener

  class BalanceHolder(view: View):RecyclerView.ViewHolder(view){

  }

  class ItemHolder(view: View) : RecyclerView.ViewHolder(view) {
    var logo: ImageView = view.logo
    var text:TextView = view.text

  }



  override fun getItemCount(): Int {
    return mList.size+1
  }

  override fun getItemViewType(position: Int): Int {
    when (position){
      BALANCE -> type = BALANCE
      ITEM -> type = ITEM
    }
    return type
  }


  override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    when (getItemViewType(position)){
      BALANCE -> {}
      ITEM -> {
        holder as ItemHolder
        var list = mList[position-1]
        holder.logo.setImageResource(list.imageId)
        holder.text.text = list.text
        list.apply {
          holder.text.setOnClickListener {
            onItemClickListener.onItemChange(position)
          }
        }
      }
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    return when (viewType) {
      BALANCE -> {
        BalanceHolder(LayoutInflater.from(parent.context).inflate(R.layout.mine_balance_item,parent,false))
      }
      else -> ItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.mine_item,parent,false))
    }

  }

  interface OnItemClickListener{
    fun onItemClick(position:Int,data:MineListBean?)
    fun onItemChange(position: Int)
  }

  fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
    this.onItemClickListener = onItemClickListener
  }
}