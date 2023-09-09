package tech.carlosktx.freegames.domain.usescase

import tech.carlosktx.freegames.domain.repository.GamesRepository
import javax.inject.Inject

class SaveGameAsFavoriteUseCase @Inject constructor(
    private val gamesRepository: GamesRepository
) {

    suspend operator fun invoke(gameId: Int) {
        gamesRepository.saveGameAsFavorite(gameId)
    }

}