package com.carlos.isc.freegames.data.remote.game

import com.carlos.isc.freegames.domain.models.GameModel

interface GameRemoteDataSource {
    suspend fun getLiveGamesList(): List<GameModel>
}

