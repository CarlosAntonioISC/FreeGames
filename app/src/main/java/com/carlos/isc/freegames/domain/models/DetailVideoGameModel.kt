package com.carlos.isc.freegames.domain.models

import com.carlos.isc.freegames.domain.enum.EnumPlatform
import com.carlos.isc.freegames.domain.io.response.MinimumSystemRequirements
import com.carlos.isc.freegames.domain.io.response.Screenshots
import com.google.gson.annotations.SerializedName

data class DetailVideoGameModel(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val status: String,
    val description: String,
    val game_url: String,
    val genre: String,
    val platform: EnumPlatform,
    val publisher: String,
    val developer: String,
    val release_date: String,
    val minimumSystemRequirements: Map<String, String>,
    val screenshots: List<String>
)