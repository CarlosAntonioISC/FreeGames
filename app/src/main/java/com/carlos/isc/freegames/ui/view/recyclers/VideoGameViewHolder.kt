package com.carlos.isc.freegames.ui.view.recyclers

import android.view.View
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.carlos.isc.freegames.R
import com.carlos.isc.freegames.databinding.ItemGameBinding
import com.carlos.isc.freegames.domain.enum.EnumPlatform
import com.carlos.isc.freegames.domain.models.VideoGameModel
import com.carlos.isc.freegames.ui.view.base.BaseViewHolder
import com.carlos.isc.freegames.ui.view.interfaces.OnClickItem

class VideoGameViewHolder(val view: View): BaseViewHolder<VideoGameModel>(view) {

    private val binding = ItemGameBinding.bind(view)

    override fun onBind(item: VideoGameModel, listener: OnClickItem<VideoGameModel>) {
        with(binding) {

            tvGameTitle.text       = item.title
            tvGameGenre.text       = item.genre
            tvGameDescription.text = item.short_description

            Glide.with(mContext).load(item.thumbnail).centerCrop().into(binding.ivGameThumbnail)

            val drawable = when(item.platform){
                EnumPlatform.PC      -> R.drawable.ic_pc
                EnumPlatform.BROWSER -> R.drawable.ic_web
                EnumPlatform.ALL     -> R.drawable.ic_all
            }

            ivGamePlatform.setImageDrawable(ContextCompat.getDrawable(mContext,drawable))

            binding.root.setOnClickListener {
                listener.onClickItem(item)
            }
        }
    }
}