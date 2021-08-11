package com.carlos.isc.freegames.domain.converters

import com.carlos.isc.freegames.domain.enum.EnumPlatform
import com.carlos.isc.freegames.domain.io.response.GameResponse
import com.carlos.isc.freegames.domain.models.GameModel


object GameResponseConverterConverter: FromResponseConverter<GameResponse, GameModel>,
    FromListResponseConverter<GameResponse, GameModel> {

    override fun fromResponse(response: GameResponse): GameModel {
        val platform = when (response.genre) {
            "PC (Windows)" -> EnumPlatform.PC
            "Web Browser" -> EnumPlatform.BROWSER
            "PC (Windows), Web Browser" -> EnumPlatform.ALL
            else -> EnumPlatform.ALL
        }
        return GameModel(
            id                = response.id.toString(),
            title             = response.title,
            thumbnail         = response.thumbnail,
            short_description = response.short_description,
            game_url          = response.game_url,
            genre             = response.genre,
            platform          = platform
        )
    }

    override fun fromListResponse(responseList: List<GameResponse>?): List<GameModel> {

        val modelList = mutableListOf<GameModel>()

        responseList?.forEach {
            modelList.add(fromResponse(it))
        }

        return modelList
    }
}