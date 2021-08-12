package com.carlos.isc.freegames.ui.view.recyclers

import android.view.View
import com.bumptech.glide.Glide
import com.carlos.isc.freegames.databinding.ItemGameBinding
import com.carlos.isc.freegames.domain.models.GameModel
import com.carlos.isc.freegames.ui.view.base.BaseViewHolder

class GameViewHolder(view: View): BaseViewHolder<GameModel>(view) {

    private val binding = ItemGameBinding.bind(view)

    override fun onBind(item: GameModel) {
        with(binding) {
            ivGameTitle.text = item.title
            tvGameGenre.text = item.genre
            ivGameDescription.text = item.short_description
            Glide.with(binding.root).load(item.thumbnail).centerCrop().into(binding.ivGameThumbnail)
        }
    }
}