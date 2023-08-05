package tech.carlosktx.freegames.ui.home.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
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
import tech.carlosktx.freegames.utils.carouselTransition

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecommendedGameList(
    title: String,
    games: List<Game>,
    onClickItem: (Game) -> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(initialPage = 3)

    Column(
        modifier = modifier.fillMaxWidth()
    ) {

        Text(
            text = title,
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp),
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )

        HorizontalPager(
            pageCount = games.size,
            state = pagerState,
            contentPadding = PaddingValues(
                horizontal = 64.dp
            ),
            pageSpacing = 16.dp
        ) { page ->
            RecommendendGameItem(
                game = games[page],
                onClickGame = { onClickItem(it) },
                modifier = Modifier.carouselTransition(page, pagerState)
            )
        }
    }

}

@Preview(
    showBackground = true,
)
@Composable
private fun RecommendedGameListPreview() {
    RecommendedGameList(
        title = stringResource(id = R.string.recommended_games),
        games = gamesDummy,
        onClickItem = {}
    )
}