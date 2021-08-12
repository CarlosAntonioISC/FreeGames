package com.carlos.isc.freegames.data.remote.game

import com.carlos.isc.freegames.domain.core.Constants
import com.carlos.isc.freegames.domain.io.response.VideoGameResponse
import retrofit2.http.GET

interface RetrofitGameWebService {
    @GET(Constants.ENDPOINT_LIVE_GAMES)
    suspend fun getLiveGamesList(): List<VideoGameResponse>?
}