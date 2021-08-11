package com.carlos.isc.freegames.domain.models

import com.carlos.isc.freegames.domain.enum.EnumPlatform

class GameModel(
    val id: String,
    val title: String,
    val thumbnail: String,
    val short_description: String,
    val game_url: String,
    val genre: String,
    val platform: EnumPlatform,
)