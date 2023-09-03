package tech.carlosktx.freegames.domain.usescase

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import tech.carlosktx.freegames.data.dummy.gameDummy1
import tech.carlosktx.freegames.data.dummy.gameDummy2
import tech.carlosktx.freegames.data.dummy.gameDummy3
import tech.carlosktx.freegames.domain.GamesIdProvider
import tech.carlosktx.freegames.domain.repository.GamesRepository

class GetRecommendedGamesUseCaseTest {

    @Test
    fun whenInvokeIsCalledThenReturnRecommendedGamesFromRepository() {
        val expectedGames = listOf(gameDummy1, gameDummy2, gameDummy3)
        val expectedGamesIds = listOf(gameDummy1.id, gameDummy2.id, gameDummy3.id)

        val gamesIdProvider: GamesIdProvider = mockk {
            every { getRecommendedGamesId() } returns expectedGamesIds
        }

        val gamesRepository: GamesRepository = mockk {
            every { getGamesById(gamesIdProvider.getRecommendedGamesId()) } returns flowOf(
                expectedGames
            )
        }

        val useCase = GetRecommendedGamesUseCase(gamesRepository, gamesIdProvider)

        val recommendedGames = runBlocking { useCase.invoke().first() }

        verify(exactly = 1) { gamesIdProvider.getRecommendedGamesId() }
        assertEquals(expectedGames, recommendedGames)

    }

}