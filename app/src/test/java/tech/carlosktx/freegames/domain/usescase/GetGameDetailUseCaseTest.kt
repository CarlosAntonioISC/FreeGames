package tech.carlosktx.freegames.domain.usescase

import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import tech.carlosktx.freegames.data.dummy.gameDetailDummy1
import tech.carlosktx.freegames.data.dummy.gameDummy1
import tech.carlosktx.freegames.domain.repository.GamesRepository

class GetGameDetailUseCaseTest {

    @Test
    fun whenInvokeIsCalledThenReturnsGameDetail() {

        val expectedGameDetail = gameDetailDummy1

        val gamesRepository: GamesRepository = mockk {
            every { getGameDetail(any()) } returns flowOf(expectedGameDetail)
        }

        val useCase = GetGameDetailUseCase(gamesRepository)

        val gameDetail = runBlocking { useCase.invoke(1).first() }

        assertEquals(expectedGameDetail, gameDetail)

    }

}