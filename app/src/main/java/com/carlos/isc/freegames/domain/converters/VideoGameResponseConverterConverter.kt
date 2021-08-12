package com.carlos.isc.freegames.domain.converters

import com.carlos.isc.freegames.domain.enum.EnumPlatform
import com.carlos.isc.freegames.domain.io.response.VideoGameResponse
import com.carlos.isc.freegames.domain.models.VideoGameModel


object VideoGameResponseConverterConverter: FromResponseConverter<VideoGameResponse, VideoGameModel>,
    FromListResponseConverter<VideoGameResponse, VideoGameModel> {

    override fun fromResponse(responseVideo: VideoGameResponse): VideoGameModel {
        val platform = when (responseVideo.platform) {
            "PC (Windows)" -> EnumPlatform.PC
            "Web Browser" -> EnumPlatform.BROWSER
            "PC (Windows), Web Browser" -> EnumPlatform.ALL
            else -> EnumPlatform.ALL
        }
        return VideoGameModel(
            id                = responseVideo.id.toString(),
            title             = responseVideo.title,
            thumbnail         = responseVideo.thumbnail,
            short_description = responseVideo.short_description,
            game_url          = responseVideo.game_url,
            genre             = responseVideo.genre,
            platform          = platform
        )
    }

    override fun fromListResponse(responseListVideo: List<VideoGameResponse>?): List<VideoGameModel> {

        val modelList = mutableListOf<VideoGameModel>()

        responseListVideo?.forEach {
            modelList.add(fromResponse(it))
        }

        return modelList
    }
}