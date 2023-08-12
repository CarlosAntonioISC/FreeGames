package tech.carlosktx.freegames.domain.usescase

import kotlinx.coroutines.flow.Flow
import tech.carlosktx.freegames.domain.model.Game
import tech.carlosktx.freegames.domain.model.GameDetail
import tech.carlosktx.freegames.domain.repository.GamesRepository
import javax.inject.Inject

class GetGameDetailUseCase @Inject constructor(
    private val gamesRepository: GamesRepository
) {

    operator fun invoke(gameId: Int): Flow<GameDetail> {
        return gamesRepository.getGameDetail(gameId)
    }

}