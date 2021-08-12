package com.carlos.isc.freegames.data.remote.game

import com.carlos.isc.freegames.domain.converters.VideoGameResponseConverterConverter
import com.carlos.isc.freegames.domain.io.response.VideoGameResponse
import com.carlos.isc.freegames.domain.models.VideoGameModel
import kotlinx.coroutines.delay
import javax.inject.Inject

class VideoGameRemoteDataSourceImpl @Inject constructor(private val webService: RetrofitGameWebService):
    VideoGameRemoteDataSource {

    override suspend fun getLiveGamesList(): List<VideoGameModel> {
        val responseVideo: List<VideoGameResponse>? = webService.getLiveGamesList()
        delay(600)
        return VideoGameResponseConverterConverter.fromListResponse(responseVideo)
    }
}