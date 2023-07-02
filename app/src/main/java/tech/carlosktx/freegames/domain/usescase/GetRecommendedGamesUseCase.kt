package tech.carlosktx.freegames.domain.usescase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tech.carlosktx.freegames.data.dummy.gamesDummy
import tech.carlosktx.freegames.domain.model.Game
import tech.carlosktx.freegames.domain.repository.GamesRepository
import javax.inject.Inject

class GetRecommendedGamesUseCase @Inject constructor(
    private val gamesRepository: GamesRepository
) {

    companion object {
        private const val NARUTO_ID = 365
        private const val FORNITE_ID = 57
        private const val DC_UNIVERSE_ID= 260
        private const val CONAN_ID = 301
        private const val HALO_ID = 515
        private const val HABBO_ID = 432
        private const val UNTURNED_ID = 204

    }

    operator fun invoke(): Flow<List<Game>> {

        val games = listOf(
            NARUTO_ID,
            FORNITE_ID,
            DC_UNIVERSE_ID,
            HABBO_ID,
            CONAN_ID,
            HALO_ID,
            UNTURNED_ID
        )

        return gamesRepository.getGamesById(games)
    }

}