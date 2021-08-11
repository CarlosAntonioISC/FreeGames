package com.carlos.isc.freegames.ui.view.recyclers

import android.view.View
import com.carlos.isc.freegames.databinding.ItemGameBinding
import com.carlos.isc.freegames.domain.models.Game
import com.carlos.isc.freegames.ui.view.base.BaseViewHolder

class GameViewHolder(view: View): BaseViewHolder<Game>(view) {

    private val  binding = ItemGameBinding.bind(view)

    override fun onBind(item: Game) {

    }
}