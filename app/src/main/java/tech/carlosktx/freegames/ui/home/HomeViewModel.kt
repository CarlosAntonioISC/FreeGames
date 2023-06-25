package tech.carlosktx.freegames.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import tech.carlosktx.freegames.domain.usescase.GetPopularGamesUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPopularGamesUseCase: GetPopularGamesUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            getPopularGamesUseCase()
                .onStart { _uiState.update { it.copy(isLoading = true) } }
                .onCompletion { _uiState.update { it.copy(isLoading = false) } }
                .collect { popularGames ->
                    _uiState.update { it.copy(popularGames = popularGames) }
                }
        }
    }

}