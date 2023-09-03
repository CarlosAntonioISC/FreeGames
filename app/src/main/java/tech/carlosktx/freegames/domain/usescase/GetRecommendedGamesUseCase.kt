package tech.carlosktx.freegames.domain.usescase

import kotlinx.coroutines.flow.Flow
import tech.carlosktx.freegames.domain.GamesIdProvider
import tech.carlosktx.freegames.domain.model.Game
import tech.carlosktx.freegames.domain.repository.GamesRepository
import javax.inject.Inject

class GetRecommendedGamesUseCase @Inject constructor(
    private val gamesRepository: GamesRepository,
    private val gameIdProvider: GamesIdProvider
) {

    operator fun invoke(): Flow<List<Game>> {
        return gamesRepository.getGamesById(gameIdProvider.getRecommendedGamesId())
    }

}