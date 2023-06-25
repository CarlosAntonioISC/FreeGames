package tech.carlosktx.freegames.data.remote.datasource

import tech.carlosktx.freegames.domain.model.Game

interface GamesRemoteDataSource {
    suspend fun getPopularGames(): List<Game>

}