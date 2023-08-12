package tech.carlosktx.freegames.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import tech.carlosktx.freegames.domain.usescase.GetPopularGamesUseCase
import tech.carlosktx.freegames.domain.usescase.GetRecommendedGamesUseCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getPopularGamesUseCase: GetPopularGamesUseCase,
    getRecommendedGamesUseCase: GetRecommendedGamesUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            getPopularGamesUseCase().combine(getRecommendedGamesUseCase()) { popularGames, recommendedGames ->
                _uiState.update {
                    it.copy(
                        popularGames = popularGames,
                        recommendedGames = recommendedGames
                    )
                }
            }.catch {
                _uiState.update { it.copy(showError = true) }
            }.collect()
            _uiState.update { it.copy(isLoading = false) }
        }
    }

}