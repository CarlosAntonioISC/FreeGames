package tech.carlosktx.freegames.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import tech.carlosktx.freegames.data.dummy.gameDetailDummy1
import tech.carlosktx.freegames.domain.model.Game
import tech.carlosktx.freegames.domain.model.GameDetail
import tech.carlosktx.freegames.domain.repository.GamesRepository

class GamesRepositoryFake(
    games: List<Game>,
    gamesDetail: List<GameDetail>
) : GamesRepository {

    private val gamesStateFlow = MutableStateFlow(games)
    private val gamesDetailFlow = MutableStateFlow(gamesDetail)

    override fun getPopularGames(): Flow<List<Game>> {
        return gamesStateFlow
    }

    override fun getGamesById(gamesId: List<Int>): Flow<List<Game>> {
        return gamesStateFlow.onEach { it.filter { game -> gamesId.contains(game.id) } }
    }

    override suspend fun getGameDetail(gameId: Int): GameDetail {
        throw Exception()
    }

    override suspend fun saveGameAsFavorite(gameId: Int) {
        var games = gamesDetailFlow.first()
        games = games.map {
            if (it.id == gameId) {
                it.copy(isFavorite = !it.isFavorite)
            } else {
                it
            }
        }
        gamesDetailFlow.update { games }
    }

}