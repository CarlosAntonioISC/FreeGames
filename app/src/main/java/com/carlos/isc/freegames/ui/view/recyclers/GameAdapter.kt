package com.carlos.isc.freegames.ui.view.recyclers

import android.view.ViewGroup
import com.carlos.isc.freegames.R
import com.carlos.isc.freegames.domain.models.GameModel
import com.carlos.isc.freegames.ui.view.base.BaseAdapter
import com.carlos.isc.freegames.ui.view.base.BaseViewHolder
import com.carlos.isc.freegames.ui.view.interfaces.OnClickItem

class GameAdapter(private val listener: OnClickItem<GameModel>): BaseAdapter<GameModel>() {

    override fun onBindViewHolder(holder: BaseViewHolder<GameModel>, position: Int) {
        holder.onBind(mItems[position], listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<GameModel> {
        val view = getViewFromLayout(parent, R.layout.item_game)
        return GameViewHolder(view)
    }
}