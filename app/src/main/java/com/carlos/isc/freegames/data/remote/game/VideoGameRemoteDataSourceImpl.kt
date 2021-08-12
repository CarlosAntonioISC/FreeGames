package com.carlos.isc.freegames.data.remote.game

import com.carlos.isc.freegames.domain.converters.DetailVideoGameResponseConverter
import com.carlos.isc.freegames.domain.converters.VideoGameResponseConverter
import com.carlos.isc.freegames.domain.io.response.DetailVideoGameResponse
import com.carlos.isc.freegames.domain.io.response.VideoGameResponse
import com.carlos.isc.freegames.domain.models.DetailVideoGameModel
import com.carlos.isc.freegames.domain.models.VideoGameModel
import kotlinx.coroutines.delay
import javax.inject.Inject

class VideoGameRemoteDataSourceImpl @Inject constructor(private val webService: RetrofitGameWebService) :
    VideoGameRemoteDataSource {

    override suspend fun getLiveGamesList(): List<VideoGameModel> {
        val response: List<VideoGameResponse>? = webService.getLiveGamesList()
        delay(600)
        return VideoGameResponseConverter.fromListResponse(response)
    }

    override suspend fun getDetailVideoGame(idGame: String): DetailVideoGameModel {
        val response: DetailVideoGameResponse? = webService.getDetailGame(idGame)

        return DetailVideoGameResponseConverter.fromResponse(response)
    }
}