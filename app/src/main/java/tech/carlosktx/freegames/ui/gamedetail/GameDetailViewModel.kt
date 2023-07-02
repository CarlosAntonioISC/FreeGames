package tech.carlosktx.freegames.ui.gamedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import tech.carlosktx.freegames.domain.usescase.GetGameByIdUseCase
import javax.inject.Inject

@HiltViewModel
class GameDetailViewModel @Inject constructor(
    private val getGameByIdUseCase: GetGameByIdUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(GameDetailUiState())
    val uiState = _uiState.asStateFlow()

    fun getGameById(gameId: Int) = viewModelScope.launch {
        getGameByIdUseCase(gameId).collect { game ->
            _uiState.update { it.copy(game = game) }
        }
    }

}