package tech.carlosktx.freegames.data.remote.retrofit.api

import retrofit2.http.GET


interface GamesApi {
    @GET()
    fun getPopularGames()
}