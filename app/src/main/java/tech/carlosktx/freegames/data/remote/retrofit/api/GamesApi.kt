package tech.carlosktx.freegames.data.remote.retrofit.api

import retrofit2.http.GET
import tech.carlosktx.freegames.data.remote.retrofit.response.GameResponse


interface GamesApi {
    @GET("games?sort-by=relevance")
    suspend fun getPopularGames(): List<GameResponse>
}