package com.carlos.isc.freegames.domain.converters

import com.carlos.isc.freegames.domain.enum.EnumPlatform
import com.carlos.isc.freegames.domain.io.response.VideoGameResponse
import com.carlos.isc.freegames.domain.models.VideoGameModel


object VideoGameResponseConverter: FromResponseConverter<VideoGameResponse, VideoGameModel>,
    FromListResponseConverter<VideoGameResponse, VideoGameModel> {

    override fun fromResponse(response: VideoGameResponse?): VideoGameModel {
        val platform = when (response?.platform) {
            "PC (Windows)" -> EnumPlatform.PC
            "Web Browser" -> EnumPlatform.BROWSER
            "PC (Windows), Web Browser" -> EnumPlatform.ALL
            else -> EnumPlatform.ALL
        }
        return VideoGameModel(
            id                = response?.id.toString(),
            title             = response?.title ?: "",
            thumbnail         = response?.thumbnail ?: "",
            short_description = response?.short_description ?: "",
            game_url          = response?.game_url ?: "",
            genre             = response?.genre ?: "",
            platform          = platform
        )
    }

    override fun fromListResponse(responseList: List<VideoGameResponse>?): List<VideoGameModel> {

        val modelList = mutableListOf<VideoGameModel>()

        responseList?.forEach {
            modelList.add(fromResponse(it))
        }

        return modelList
    }
}