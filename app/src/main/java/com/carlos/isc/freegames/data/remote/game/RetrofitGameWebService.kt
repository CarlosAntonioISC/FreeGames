package com.carlos.isc.freegames.data.remote.game

import com.carlos.isc.freegames.domain.core.Constants
import com.carlos.isc.freegames.domain.io.response.DetailVideoGameResponse
import com.carlos.isc.freegames.domain.io.response.VideoGameResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitGameWebService {

    @GET(Constants.ENDPOINT_LIVE_GAMES)
    suspend fun getLiveGamesList(): List<VideoGameResponse>?

    @GET(Constants.ENDPOINT_DETAIL_GAME)
    suspend fun getDetailGame(@Query(value = "id") idGame: String): DetailVideoGameResponse?
}