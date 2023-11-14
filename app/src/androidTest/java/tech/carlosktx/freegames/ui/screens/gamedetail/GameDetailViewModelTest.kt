package tech.carlosktx.freegames.ui.screens.gamedetail

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import tech.carlosktx.freegames.data.MockWebServerRule
import tech.carlosktx.freegames.di.CoroutinesTestRule
import tech.carlosktx.freegames.domain.usescase.GetGameDetailUseCase
import tech.carlosktx.freegames.ui.navigation.NavArg
import javax.inject.Inject

@HiltAndroidTest
class GameDetailViewModelTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val mockWebServerRule = MockWebServerRule()

    @get:Rule(order = 2)
    val coroutinesTestRule = CoroutinesTestRule()

    private lateinit var gameDetailViewModel: GameDetailViewModel
    @Inject
    lateinit var getGameDetailUseCase: GetGameDetailUseCase

    @Before
    fun setUp() {
        hiltRule.inject()
        val savedState = SavedStateHandle(mapOf(NavArg.ItemId.key to 1))
        gameDetailViewModel = GameDetailViewModel(getGameDetailUseCase, savedState)
    }

    @Test
    fun game_detail_is_obtained_by_id() {
        assertEquals(GameDetailUiState(), gameDetailViewModel.uiState.value)

    }

}