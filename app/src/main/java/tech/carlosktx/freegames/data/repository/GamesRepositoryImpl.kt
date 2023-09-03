package tech.carlosktx.freegames.data.repository

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tech.carlosktx.freegames.data.remote.datasource.GamesRemoteDataSource
import tech.carlosktx.freegames.domain.mapper.toGame
import tech.carlosktx.freegames.domain.model.Game
import tech.carlosktx.freegames.domain.model.GameDetail
import tech.carlosktx.freegames.domain.repository.GamesRepository
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(
    private val remoteDataSource: GamesRemoteDataSource
): GamesRepository {

    override fun getPopularGames(): Flow<List<Game>> {
        return flow {
            emit(remoteDataSource.getPopularGames())
        }
    }
    override fun getGamesById(gamesId: List<Int>): Flow<List<Game>> {
        return flow {
            coroutineScope {
                val gamesIdAsync = mutableListOf<Deferred<Game>>()
                gamesId.forEach {
                    gamesIdAsync.add(
                        async { remoteDataSource.getGameById(it).toGame() }
                    )
                }
                emit(gamesIdAsync.awaitAll())
            }
        }
    }

    override fun getGameDetail(gameId: Int): Flow<GameDetail> {
        return flow {
           emit(remoteDataSource.getGameById(gameId))
        }
    }

}