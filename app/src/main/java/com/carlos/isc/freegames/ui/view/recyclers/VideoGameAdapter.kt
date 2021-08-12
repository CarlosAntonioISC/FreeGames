package com.carlos.isc.freegames.ui.view.recyclers

import android.view.ViewGroup
import com.carlos.isc.freegames.R
import com.carlos.isc.freegames.domain.models.VideoGameModel
import com.carlos.isc.freegames.ui.view.base.BaseAdapter
import com.carlos.isc.freegames.ui.view.base.BaseViewHolder
import com.carlos.isc.freegames.ui.view.interfaces.OnClickItem

class VideoGameAdapter(private val listener: OnClickItem<VideoGameModel>): BaseAdapter<VideoGameModel>() {

    override fun onBindViewHolder(holder: BaseViewHolder<VideoGameModel>, position: Int) {
        holder.onBind(mItems[position], listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VideoGameModel> {
        val view = getViewFromLayout(parent, R.layout.item_game)
        return VideoGameViewHolder(view)
    }
}