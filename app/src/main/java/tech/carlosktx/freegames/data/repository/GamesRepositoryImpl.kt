package tech.carlosktx.freegames.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tech.carlosktx.freegames.data.remote.datasource.GamesRemoteDataSource
import tech.carlosktx.freegames.domain.model.Game
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

}