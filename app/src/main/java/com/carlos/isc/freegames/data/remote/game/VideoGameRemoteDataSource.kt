package com.carlos.isc.freegames.data.remote.game

import com.carlos.isc.freegames.domain.models.VideoGameModel

interface VideoGameRemoteDataSource {
    suspend fun getLiveGamesList(): List<VideoGameModel>
}

