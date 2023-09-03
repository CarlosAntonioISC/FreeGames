package tech.carlosktx.freegames.domain.usescase

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import tech.carlosktx.freegames.data.dummy.gameDummy1
import tech.carlosktx.freegames.data.dummy.gameDummy2
import tech.carlosktx.freegames.data.dummy.gameDummy3
import tech.carlosktx.freegames.domain.repository.GamesRepository

class GetPopularGamesUseCaseTest {

    @Test
    fun whenInvokeIsCalledThenReturnGamesFromRepository() {

        val popularGamesExpected = listOf(gameDummy1, gameDummy2, gameDummy3)

        val gamesRepository: GamesRepository = mockk {
            every { getPopularGames() } returns flowOf(popularGamesExpected)
        }

        val useCase = GetPopularGamesUseCase(gamesRepository)

        val popularGames = runBlocking { useCase.invoke().first() }

        assertEquals(popularGamesExpected, popularGames)
    }

}