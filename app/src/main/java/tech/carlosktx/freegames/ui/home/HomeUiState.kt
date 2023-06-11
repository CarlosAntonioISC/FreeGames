package tech.carlosktx.freegames.ui.home

import tech.carlosktx.freegames.domain.model.Game

data class HomeUiState(
    val isLoading: Boolean = false,
    val popularGames: List<Game> = emptyList()
)