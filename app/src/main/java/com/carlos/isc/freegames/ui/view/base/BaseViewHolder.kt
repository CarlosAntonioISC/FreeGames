package com.carlos.isc.freegames.ui.view.base

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewHolder<T>(view: View): RecyclerView.ViewHolder(view) {

    protected val mContext: Context = view.context

    abstract fun onBind(item: T)
}