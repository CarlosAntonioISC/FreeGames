package tech.carlosktx.freegames.ui.screens.home.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.carlosktx.freegames.R
import tech.carlosktx.freegames.data.dummy.gamesDummy
import tech.carlosktx.freegames.domain.model.Game

@Composable
fun GenericGameList(
    title: String,
    games: List<Game>,
    onClickItem: (Game) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        TitleSection(title)
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(items = games, key = { it.id }) {
                GenericGameItem(
                    game = it,
                    onClickGame = { game -> onClickItem(game) },
                    modifier = Modifier.fillMaxHeight()
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(
    showBackground = true,
    heightDp = 300
)
@Composable
private fun RecommendedGameListPreview() {
    GenericGameList(
        title = stringResource(id = R.string.popular_games),
        games = gamesDummy,
        onClickItem = {}
    )
}