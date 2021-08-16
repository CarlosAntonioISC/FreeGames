package com.carlos.isc.freegames.domain.converters

import com.carlos.isc.freegames.domain.enum.EnumPlatform
import com.carlos.isc.freegames.domain.io.response.DetailVideoGameResponse
import com.carlos.isc.freegames.domain.models.DetailVideoGameModel

object DetailVideoGameResponseConverter :
    FromResponseConverter<DetailVideoGameResponse, DetailVideoGameModel> {
    override fun fromResponse(response: DetailVideoGameResponse?): DetailVideoGameModel {

        val platform = when (response?.platform) {
            "Windows" -> EnumPlatform.PC
            "Web Browser" -> EnumPlatform.BROWSER
            else -> EnumPlatform.ALL
        }

        val minimumSystemRequirements = mapOf(
            "os" to (response?.minimumSystemRequirements?.os?: ""),
            "processor" to (response?.minimumSystemRequirements?.processor ?: ""),
            "memory" to (response?.minimumSystemRequirements?.memory ?: ""),
            "graphics" to (response?.minimumSystemRequirements?.graphics ?: ""),
            "storage" to (response?.minimumSystemRequirements?.storage ?: ""),
        )

        val screenshots = mutableListOf<String>()
        response?.screenshots?.forEach {
            screenshots.add(it.image ?: "")
        }

        return DetailVideoGameModel(
            id = response?.id ?: 0,
            title = response?.title ?: "",
            thumbnail = response?.thumbnail ?: "",
            status = response?.status ?: "",
            description = response?.description ?: "",
            game_url = response?.game_url ?: "",
            genre = response?.genre ?: "",
            platform = platform,
            publisher = response?.publisher ?: "",
            developer = response?.developer ?: "",
            release_date = response?.release_date ?: "",
            minimumSystemRequirements = minimumSystemRequirements,
            screenshots = screenshots
        )
    }
}