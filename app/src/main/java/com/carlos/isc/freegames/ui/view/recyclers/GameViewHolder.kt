package com.carlos.isc.freegames.ui.view.recyclers

import android.view.View
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.carlos.isc.freegames.R
import com.carlos.isc.freegames.databinding.ItemGameBinding
import com.carlos.isc.freegames.domain.enum.EnumPlatform
import com.carlos.isc.freegames.domain.models.GameModel
import com.carlos.isc.freegames.ui.view.base.BaseViewHolder

class GameViewHolder(val view: View): BaseViewHolder<GameModel>(view) {

    private val binding = ItemGameBinding.bind(view)

    override fun onBind(item: GameModel) {
        with(binding) {
            ivGameTitle.text = item.title
            tvGameGenre.text = item.genre
            ivGameDescription.text = item.short_description

            Glide.with(mContext).load(item.thumbnail).centerCrop().into(binding.ivGameThumbnail)

            val drawable = when(item.platform){
                EnumPlatform.PC      -> R.drawable.ic_pc
                EnumPlatform.BROWSER -> R.drawable.ic_web
                EnumPlatform.ALL     -> R.drawable.ic_all
            }

            ivGamePlatform.setImageDrawable(ContextCompat.getDrawable(mContext,drawable))
        }
    }
}