package com.carlos.isc.freegames.ui.view.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T>: RecyclerView.Adapter<BaseViewHolder<T>>() {

    protected var mItems = mutableListOf<T>()

    fun updateData(newList: MutableList<T>){
        mItems.clear()
        mItems.addAll(newList)
        notifyDataSetChanged()
    }

    protected open fun getViewFromLayout(viewGroup: ViewGroup, layout: Int): View {
        return LayoutInflater.from(viewGroup.context).inflate(layout, viewGroup, false)
    }

    override fun getItemCount(): Int = mItems.size
}