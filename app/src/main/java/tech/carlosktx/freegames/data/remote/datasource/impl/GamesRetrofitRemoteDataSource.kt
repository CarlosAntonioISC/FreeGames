package tech.carlosktx.freegames.data.remote.datasource.impl

import android.util.Log
import tech.carlosktx.freegames.data.remote.datasource.GamesRemoteDataSource
import tech.carlosktx.freegames.data.remote.mapper.toGameModel
import tech.carlosktx.freegames.data.remote.retrofit.api.GamesApi
import tech.carlosktx.freegames.domain.model.Game
import tech.carlosktx.freegames.domain.model.GameDetail
import tech.carlosktx.freegames.domain.model.Genre
import javax.inject.Inject

class GamesRetrofitRemoteDataSource @Inject constructor(
    private val gamesApi: GamesApi
) : GamesRemoteDataSource {

    override suspend fun getPopularGames(): List<Game> {
        return gamesApi.getPopularGames().map { it.toGameModel() }
    }

    override suspend fun getGameById(id: Int): GameDetail {
        return gamesApi.getGameById(id).toGameModel()
    }

}