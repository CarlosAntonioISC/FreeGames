package tech.carlosktx.freegames.ui.screens.gamedetail.integration

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import tech.carlosktx.freegames.data.dummy.gameDetailDummy1
import tech.carlosktx.freegames.data.dummy.gamesDetailDummy
import tech.carlosktx.freegames.data.dummy.gamesDummy
import tech.carlosktx.freegames.data.repository.GamesRepositoryFake
import tech.carlosktx.freegames.domain.usescase.GetGameDetailUseCase
import tech.carlosktx.freegames.domain.usescase.SaveGameAsFavoriteUseCase
import tech.carlosktx.freegames.rules.CoroutinesTestRule
import tech.carlosktx.freegames.ui.navigation.NavArg
import tech.carlosktx.freegames.ui.screens.gamedetail.GameDetailUiState
import tech.carlosktx.freegames.ui.screens.gamedetail.GameDetailViewModel


class GameDetailViewModelTest {

    @get:Rule
    val mockkRule = MockKRule(this)

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @MockK
    lateinit var stateHandle: SavedStateHandle
    private lateinit var gameDetailUseCase: GetGameDetailUseCase
    private lateinit var saveGameAsFavoriteUseCase: SaveGameAsFavoriteUseCase
    private lateinit var viewModel: GameDetailViewModel
    private val idGame = 1

    @Before
    fun setUp() {
        every { stateHandle.get<Int>(NavArg.ItemId.key) } returns idGame
        val gamesRepository = GamesRepositoryFake(gamesDummy, gamesDetailDummy)
        gameDetailUseCase = GetGameDetailUseCase(gamesRepository)
        saveGameAsFavoriteUseCase = SaveGameAsFavoriteUseCase(gamesRepository)
        viewModel = GameDetailViewModel(gameDetailUseCase, saveGameAsFavoriteUseCase, stateHandle)
    }

    @Test
    fun whenGameIsSelectedAsFavoriteThenGameIsUpdated() = runTest {
        viewModel.uiState.test {
            assertEquals(GameDetailUiState(), awaitItem())
            viewModel.getGameById()
            assertEquals(GameDetailUiState(game = gameDetailDummy1), awaitItem())
            viewModel.onClickedGameFavorite()
            //TODO pending favorite feature
        }
    }

}