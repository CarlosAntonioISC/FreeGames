package tech.carlosktx.freegames.domain.repository

import kotlinx.coroutines.flow.Flow
import tech.carlosktx.freegames.domain.model.Game
import tech.carlosktx.freegames.domain.model.GameDetail

interface GamesRepository {
    fun getPopularGames(): Flow<List<Game>>
    fun getGamesById(gamesId: List<Int>): Flow<List<Game>>
    fun getGameDetail(gameId: Int): Flow<GameDetail>
    suspend fun saveGameAsFavorite(gameId: Int)
}