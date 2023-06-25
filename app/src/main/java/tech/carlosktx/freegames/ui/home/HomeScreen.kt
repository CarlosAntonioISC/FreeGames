package tech.carlosktx.freegames.ui.home

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import tech.carlosktx.freegames.R
import tech.carlosktx.freegames.data.dummy.gamesDummy
import tech.carlosktx.freegames.domain.model.Game
import tech.carlosktx.freegames.ui.home.composables.GenericGameList
import tech.carlosktx.freegames.ui.home.composables.ImportantGameList
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
        verticalArrangement = Arrangement.Bottom
    ) {
        ImportantGameList(
            title = stringResource(id = R.string.recommended_games),
            games = uiState.popularGames.take(5),
            onClickItem = {
                onClickGame(it)
            })

        GenericGameList(
            title = stringResource(id = R.string.popular_games),
            games = uiState.popularGames,
            onClickItem = {
                onClickGame(it)
            })
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
                popularGames = gamesDummy
            )
            HomeScreen(uiState = uiState, onClickGame = {})
        }
    }
}