package tech.carlosktx.freegames.data.remote.retrofit.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import tech.carlosktx.freegames.data.remote.retrofit.response.GameDetailResponse
import tech.carlosktx.freegames.data.remote.retrofit.response.GameResponse


interface GamesApi {
    @GET("games?sort-by=relevance")
    suspend fun getPopularGames(): List<GameResponse>

    @GET("game")
    suspend fun getGameById(@Query("id") id: Int): GameDetailResponse

}