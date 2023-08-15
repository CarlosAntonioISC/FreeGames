package tech.carlosktx.freegames.ui.gamedetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.carlosktx.freegames.R
import tech.carlosktx.freegames.domain.model.GameDetail
import tech.carlosktx.freegames.ui.common.BackIcon
import tech.carlosktx.freegames.ui.common.FavoriteButton
import tech.carlosktx.freegames.ui.common.TextGenre
import tech.carlosktx.freegames.ui.gamedetail.composables.GameDetailImagesCarousel
import tech.carlosktx.freegames.ui.theme.FreeGamesTheme

@Composable
fun GameDetailScreen(
    uiState: GameDetailUiState,
    onClickIconBack: () -> Unit
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        GameDetailContentTop(
            onClickIconBack = onClickIconBack,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        uiState.game?.let { gameDetail ->
            Column(
                modifier = Modifier.verticalScroll(state = scrollState)
            ) {
                GameDetailImagesCarousel(
                    images = gameDetail.screenshots.map { it.image },
                    modifier = Modifier.padding(bottom = 32.dp)
                )
                DetailGameDescription(gameDetail)
            }
        }
    }
}

@Composable
private fun GameDetailContentTop(onClickIconBack: () -> Unit, modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        BackIcon(onClickButton = onClickIconBack)
        Text(text = "Game Detail", style = MaterialTheme.typography.headlineMedium)
        FavoriteButton(isFavorite = false, onClickButton = {})
    }
}

@Composable
fun DetailGameDescription(gameDetail: GameDetail) {
    Column {
        Text(
            text = gameDetail.title, style = MaterialTheme.typography.displaySmall.copy(
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = gameDetail.developer, style = MaterialTheme.typography.titleMedium
        )
        Row(
            modifier = Modifier.padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_windows),
                contentDescription = "",
                modifier = Modifier.size(32.dp)
            )
            TextGenre(gameDetail.genre)
        }
        Text(
            text = "Game Description",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 24.dp, bottom = 16.dp)
        )
        Text(
            text = gameDetail.description, style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )
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
            GameDetailScreen(uiState = uiState) {}
        }
    }
}