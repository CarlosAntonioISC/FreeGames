package com.carlos.isc.freegames.domain.repository

import com.carlos.isc.freegames.domain.models.VideoGameModel

interface VideoGameRepository {

    suspend fun getLiveGamesList(): List<VideoGameModel>

}