package tech.carlosktx.freegames.data.repository

import io.mockk.coEvery
import io.mockk.coJustRun
import io.mockk.coVerify
import io.mockk.coVerifyAll
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import tech.carlosktx.freegames.data.dummy.gameDetailDummy1
import tech.carlosktx.freegames.data.dummy.gameDetailDummy2
import tech.carlosktx.freegames.data.dummy.gameDetailDummy3
import tech.carlosktx.freegames.data.dummy.gameDummy1
import tech.carlosktx.freegames.data.dummy.gameDummy2
import tech.carlosktx.freegames.data.dummy.gameDummy3
import tech.carlosktx.freegames.data.remote.datasource.GamesRemoteDataSource

class GamesRepositoryImplTest {

    @get:Rule
    val mockkRule = MockKRule(this)
    private lateinit var gamesRepository: GamesRepositoryImpl

    @MockK
    lateinit var gamesRemoteDataSource: GamesRemoteDataSource

    @Before
    fun setUp() {
        gamesRepository = GamesRepositoryImpl(gamesRemoteDataSource)
    }

    @Test
    fun whenPopularGamesAreRequestedTheyAreRetrievedFromRemoteDataSource() = runTest {
        coJustRun { gamesRemoteDataSource.getPopularGames() }
        gamesRepository.getPopularGames().first()
        coVerify { gamesRemoteDataSource.getPopularGames() }
    }

    @Test
    fun whenGamesByIdAreRequestedTheyAreRetrievedFromRemoteDataSource() {

        val expectedGames = listOf(gameDetailDummy1, gameDetailDummy2, gameDetailDummy3)
        val expectedGamesIds = listOf(gameDummy1.id, gameDummy2.id, gameDummy3.id)

        coEvery { gamesRemoteDataSource.getGameById(any()) } coAnswers {
            val gameId = firstArg<Int>()
            expectedGames.find { it.id == gameId }!!
        }

        runBlocking {  gamesRepository.getGamesById(expectedGamesIds).first() }

        coVerifyAll {
            gamesRemoteDataSource.getGameById(gameDummy3.id)
            gamesRemoteDataSource.getGameById(gameDummy2.id)
            gamesRemoteDataSource.getGameById(gameDummy1.id)
        }
    }

    @Test
    fun whenGameDetailIsRequestedItsRetrievedFromRemoteDataSource() {
        val gameId = 1
        coJustRun { gamesRemoteDataSource.getGameById(gameId) }
        runBlocking { gamesRepository.getGameDetail(gameId).first() }
        coVerify { gamesRemoteDataSource.getGameById(gameId) }
    }
}