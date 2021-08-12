package com.carlos.isc.freegames.data.remote.game

import com.carlos.isc.freegames.domain.io.response.DetailVideoGameResponse
import com.carlos.isc.freegames.domain.models.DetailVideoGameModel
import com.carlos.isc.freegames.domain.models.VideoGameModel

interface VideoGameRemoteDataSource {

    suspend fun getLiveGamesList(): List<VideoGameModel>
    suspend fun getDetailVideoGame(idGame: String): DetailVideoGameModel
}

