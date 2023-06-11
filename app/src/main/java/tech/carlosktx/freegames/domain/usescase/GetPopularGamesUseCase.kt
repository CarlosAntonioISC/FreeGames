package tech.carlosktx.freegames.domain.usescase

import tech.carlosktx.freegames.domain.repository.GamesRepository
import javax.inject.Inject

class GetPopularGamesUseCase @Inject constructor(
    private val gamesRepository: GamesRepository
) {

     operator fun invoke() = gamesRepository.getPopularGames()

}