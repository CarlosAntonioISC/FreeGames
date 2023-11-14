package tech.carlosktx.freegames.domain.usescase

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import tech.carlosktx.freegames.data.dummy.gameDetailDummy1
import tech.carlosktx.freegames.domain.repository.GamesRepository

class GetGameDetailUseCaseTest {

    @Test
    fun whenInvokeIsCalledThenReturnsGameDetail() {

        val expectedGameDetail = gameDetailDummy1

        val gamesRepository: GamesRepository = mockk {
            coEvery { getGameDetail(any()) } returns expectedGameDetail
        }

        val useCase = GetGameDetailUseCase(gamesRepository)

        val gameDetail = runBlocking { useCase.invoke(1) }

        assertEquals(expectedGameDetail, gameDetail)

    }

}