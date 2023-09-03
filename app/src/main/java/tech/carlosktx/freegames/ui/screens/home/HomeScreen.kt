package tech.carlosktx.freegames.ui.screens.home

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import tech.carlosktx.freegames.R
import tech.carlosktx.freegames.data.dummy.gamesDummy
import tech.carlosktx.freegames.domain.model.Game
import tech.carlosktx.freegames.domain.model.Category
import tech.carlosktx.freegames.ui.common.ErrorScreen
import tech.carlosktx.freegames.ui.screens.home.composables.GenericGameList
import tech.carlosktx.freegames.ui.screens.home.composables.CategoryList
import tech.carlosktx.freegames.ui.screens.home.composables.RecommendedGameList
import tech.carlosktx.freegames.ui.theme.FreeGamesTheme

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onClickGame: (Game) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Top
    ) {
        if (uiState.showError) {
            ErrorScreen()
        } else {
            if (uiState.isLoading) {
                LinearProgressIndicator(
                    modifier = Modifier
                        .semantics(mergeDescendants = true) {}
                        .fillMaxWidth()
                )
            }
            CategoryList(categories = Category.values().asList(), modifier = Modifier.weight(0.275f))
            RecommendedGameList(
                title = stringResource(id = R.string.recommended_games),
                games = uiState.recommendedGames,
                onClickItem = { onClickGame(it) },
                modifier = Modifier.weight(0.45f)
            )
            GenericGameList(
                title = stringResource(id = R.string.popular_games),
                games = uiState.popularGames,
                onClickItem = { onClickGame(it) },
                modifier = Modifier.weight(0.275f)
            )
        }
    }
}

@Preview(
    device = "id:pixel_6_pro",
    showBackground = true,
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE,
    showSystemUi = true,
    apiLevel = Build.VERSION_CODES.TIRAMISU
)
@Composable
fun HomeScreenPreview() {
    FreeGamesTheme {
        Surface(
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        ) {
            val uiState = HomeUiState(
                isLoading = false,
                recommendedGames = gamesDummy,
                popularGames = gamesDummy
            )
            HomeScreen(uiState = uiState, onClickGame = {})
        }
    }
}