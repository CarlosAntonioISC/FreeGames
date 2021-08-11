package com.carlos.isc.freegames.domain.repository

import com.carlos.isc.freegames.domain.models.Game

interface GameRepository {

    suspend fun getLiveGamesList(): List<Game>

}