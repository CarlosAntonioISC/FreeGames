package tech.carlosktx.freegames.ui.gamedetail

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import tech.carlosktx.freegames.data.dummy.gameDummy1
import tech.carlosktx.freegames.ui.theme.FreeGamesTheme

@Composable
fun GameDetailScreen(
    uiState: GameDetailUiState
) {
    Text(text = uiState.game?.title.orEmpty())
}

@Preview
@Composable
fun GameDetailScreenPreview() {
    FreeGamesTheme {
        Surface(
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        ) {
            val uiState = GameDetailUiState(
                game = gameDummy1
            )
            GameDetailScreen(uiState = uiState)
        }
    }
}