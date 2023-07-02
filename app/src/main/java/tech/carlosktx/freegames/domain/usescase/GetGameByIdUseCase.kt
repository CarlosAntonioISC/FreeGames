package tech.carlosktx.freegames.domain.usescase

import kotlinx.coroutines.flow.Flow
import tech.carlosktx.freegames.domain.model.Game
import tech.carlosktx.freegames.domain.repository.GamesRepository
import javax.inject.Inject

class GetGameByIdUseCase @Inject constructor(
    private val gamesRepository: GamesRepository
) {

    operator fun invoke(gameId: Int): Flow<Game> {
        return gamesRepository.getGameById(gameId)
    }

}