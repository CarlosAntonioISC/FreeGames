package tech.carlosktx.freegames.data.remote.datasource

import tech.carlosktx.freegames.domain.model.Game
import tech.carlosktx.freegames.domain.model.GameDetail

interface GamesRemoteDataSource {
    suspend fun getPopularGames(): List<Game>

    suspend fun getGameById(id: Int): GameDetail

}