package com.carlos.isc.freegames.data.remote.game

import com.carlos.isc.freegames.domain.converters.GameConverter
import com.carlos.isc.freegames.domain.io.response.GameResponse
import com.carlos.isc.freegames.domain.models.GameModel
import javax.inject.Inject

class GameRemoteDataSourceImpl @Inject constructor(private val webService: RetrofitGameWebService):
    GameRemoteDataSource {

    override suspend fun getLiveGamesList(): List<GameModel> {
        val response: List<GameResponse>? = webService.getLiveGamesList()
        return GameConverter.fromListResponse(response)
    }
}