package tech.carlosktx.freegames.domain.repository

import kotlinx.coroutines.flow.Flow
import tech.carlosktx.freegames.domain.model.Game

interface GamesRepository {
    fun getPopularGames(): Flow<List<Game>>
    fun getGamesById(gamesId: List<Int>): Flow<List<Game>>
    fun getGameById(gameId: Int): Flow<Game>

}