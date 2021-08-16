package com.carlos.isc.freegames.ui.view.viewHelpers

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.carlos.isc.freegames.R
import com.carlos.isc.freegames.databinding.FragmentVideoGameBinding
import com.carlos.isc.freegames.domain.enum.EnumPlatform
import com.carlos.isc.freegames.domain.models.DetailVideoGameModel
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

class ViewHelperVideoGameFragment(binding: FragmentVideoGameBinding, val context: Context, val listener: Listener) {

    private val tvGameTitle: TextView = binding.tvGameTitle
    private val tvGamePublisher: TextView = binding.tvGamePublisher
    private val gameDescription: TextView = binding.tvGameDescription

    private val tvGameGenre: TextView = binding.tvGameGenre
    private val tvGameSO: TextView = binding.tvGameSO
    private val tvGameProcessor: TextView = binding.tvGameProcessor
    private val tvGameMemory: TextView = binding.tvGameMemory
    private val tvGameGraphics: TextView = binding.tvGameGraphics
    private val tvGameStorage: TextView = binding.tvGameStorage

    private val ivGameThumbnail: ImageView = binding.ivGameThumbnail
    private val ivGamePlatform: ImageView = binding.ivGamePlatform

    private val btnPlayNow: Button = binding.playNow

    private val imageCarousel: ImageCarousel = binding.carousel

    fun loadData(videoGame: DetailVideoGameModel) {

        Glide.with(context).load(videoGame.thumbnail).into(ivGameThumbnail)

        tvGameTitle.text = videoGame.title
        tvGamePublisher.text = videoGame.publisher
        gameDescription.text = videoGame.description

        val drawable = when (videoGame.platform) {
            EnumPlatform.PC -> R.drawable.ic_pc
            EnumPlatform.BROWSER -> R.drawable.ic_web
            EnumPlatform.ALL -> R.drawable.ic_all
        }

        ivGamePlatform.setImageDrawable(ContextCompat.getDrawable(context, drawable))

        tvGameGenre.text = videoGame.genre
        tvGameSO.text = "Operating system: ${videoGame.minimumSystemRequirements["os"]}"
        tvGameProcessor.text = "Processor: ${videoGame.minimumSystemRequirements["processor"]}"
        tvGameMemory.text = "Memory: ${videoGame.minimumSystemRequirements["memory"]}"
        tvGameGraphics.text = "Graphics: ${videoGame.minimumSystemRequirements["graphics"]}"
        tvGameStorage.text = "Storage: ${videoGame.minimumSystemRequirements["storage"]}"

        openURL(videoGame.game_url)

        setupCarousel(videoGame)
    }

    private fun setupCarousel(item: DetailVideoGameModel) {
        listener.addLifeCycleToImageCarousel(imageCarousel)
        val list = mutableListOf<CarouselItem>()
        item.screenshots.forEach {
            list.add(CarouselItem(imageUrl = it))
        }
        imageCarousel.setData(list)
    }

    private fun openURL(url: String) {
        btnPlayNow.setOnClickListener {
            listener.startActivityURL(url)
        }
    }

    interface Listener {
        fun addLifeCycleToImageCarousel(imageCarousel: ImageCarousel)
        fun startActivityURL(url: String)
    }
}