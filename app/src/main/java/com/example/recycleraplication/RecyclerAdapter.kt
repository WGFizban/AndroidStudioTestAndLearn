package com.example.recycleraplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleraplication.MainActivity.Companion.basicList
import kotlinx.android.synthetic.main.row.view.*

class RecyclerAdapter(private val context: Context): RecyclerView.Adapter<CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
      val layoutInflater = LayoutInflater.from(context)
        return  CustomViewHolder(layoutInflater.inflate(R.layout.row,parent,false))
    }

    override fun getItemCount(): Int {
        return basicList.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        val name = holder.itemView.tv_name
        val pkt = holder.itemView.tv_pkt
        name.text = basicList[position]
        pkt.text = CustomDataBase.playerPktList[position].toString()
    }
}


class CustomViewHolder(view: View): RecyclerView.ViewHolder(view)