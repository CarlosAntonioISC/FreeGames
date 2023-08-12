package tech.carlosktx.freegames.ui.gamedetail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import tech.carlosktx.freegames.domain.usescase.GetGameDetailUseCase
import tech.carlosktx.freegames.ui.NavArg
import tech.carlosktx.freegames.ui.NavigationGameDetailScreen
import javax.inject.Inject

@HiltViewModel
class GameDetailViewModel @Inject constructor(
    private val getGameByIdUseCase: GetGameDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameDetailUiState())
    val uiState = _uiState.asStateFlow()
    private val idGame = savedStateHandle.get<Int>(NavigationGameDetailScreen.gameIdArg.key) ?: 0

    init {
        getGameById(idGame)
    }

    private fun getGameById(gameId: Int) = viewModelScope.launch {
        getGameByIdUseCase(gameId).collect { game ->
            _uiState.update { it.copy(game = game) }
        }
    }

}