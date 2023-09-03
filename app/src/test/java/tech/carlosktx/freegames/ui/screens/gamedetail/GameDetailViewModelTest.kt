package tech.carlosktx.freegames.ui.screens.gamedetail

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.verify
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import tech.carlosktx.freegames.data.dummy.gameDetailDummy1
import tech.carlosktx.freegames.domain.usescase.GetGameDetailUseCase
import tech.carlosktx.freegames.rules.CoroutinesTestRule
import tech.carlosktx.freegames.ui.navigation.NavArg

class GameDetailViewModelTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @get:Rule
    val mockkRule = MockKRule(this)

    private lateinit var gameDetailViewModel: GameDetailViewModel
    @MockK
    lateinit var gameDetailUseCase: GetGameDetailUseCase
    @MockK
    lateinit var stateHandle: SavedStateHandle
    private val idGame = 1

    @Before
    fun setUp() {
        every { stateHandle.get<Int>(NavArg.ItemId.key) } returns idGame
        gameDetailViewModel = GameDetailViewModel(gameDetailUseCase, stateHandle)
    }

    @Test
    fun viewModelShouldCallGetGameAndUpdateUiState() = runTest {

        val expectedGameDetail = gameDetailDummy1

        every { gameDetailUseCase.invoke(idGame) } returns flowOf(expectedGameDetail)

        gameDetailViewModel.uiState.test {
            assertEquals(GameDetailUiState(), awaitItem())
            gameDetailViewModel.getGameById()
            assertEquals(GameDetailUiState(game = expectedGameDetail), awaitItem())
        }

        verify(exactly = 1) { gameDetailUseCase(idGame) }

    }


}