package tech.carlosktx.freegames.data.remote.datasource

import tech.carlosktx.freegames.domain.model.Game

interface GamesRemoteDataSource {
    fun getPopularGames(): List<Game>
}