package tech.carlosktx.freegames.domain.usescase

import tech.carlosktx.freegames.domain.model.GameDetail
import tech.carlosktx.freegames.domain.repository.GamesRepository
import javax.inject.Inject

class GetGameDetailUseCase @Inject constructor(
    private val gamesRepository: GamesRepository
) {

    suspend operator fun invoke(gameId: Int): GameDetail {
        return gamesRepository.getGameDetail(gameId)
    }

}