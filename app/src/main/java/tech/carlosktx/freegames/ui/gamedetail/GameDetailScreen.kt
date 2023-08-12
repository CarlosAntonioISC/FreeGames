package tech.carlosktx.freegames.ui.gamedetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.carlosktx.freegames.data.dummy.gameDummy1
import tech.carlosktx.freegames.ui.gamedetail.composables.GameDetailImagesCarousel
import tech.carlosktx.freegames.ui.theme.FreeGamesTheme

@Composable
fun GameDetailScreen(uiState: GameDetailUiState) {
    uiState.game?.let { gameDetail ->
        Column() {
            GameDetailImagesCarousel(
                images = gameDetail.screenshots.map { it.image },
                 modifier = Modifier.padding(vertical = 32.dp, horizontal = 16.dp)
            )
        }
    }
}

@Preview
@Composable
fun GameDetailScreenPreview() {
    FreeGamesTheme {
        Surface(
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        ) {
            val uiState = GameDetailUiState(game = null)
            GameDetailScreen(uiState = uiState)
        }
    }
}