package tech.carlosktx.freegames.ui.home.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import tech.carlosktx.freegames.R
import tech.carlosktx.freegames.data.dummy.gamesDummy
import tech.carlosktx.freegames.domain.model.Game
import tech.carlosktx.freegames.ui.common.DotsIndicator
import tech.carlosktx.freegames.utils.carouselTransition
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RecommendedGameList(
    title: String,
    games: List<Game>,
    onClickItem: (Game) -> Unit,
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(initialPage = 3)
    val pageCount = games.size
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        TitleSection(title)
        HorizontalPager(
            pageCount = pageCount,
            state = pagerState,
            contentPadding = PaddingValues(
                horizontal = 64.dp
            ),
            pageSpacing = 16.dp
        ) { page ->
            RecommendedGameItem(
                game = games[page],
                onClickGame = { onClickItem(it) },
                modifier = Modifier
                    .carouselTransition(page, pagerState)
                    .graphicsLayer {
                        val pageOffset = (
                                (pagerState.currentPage - page) + pagerState
                                    .currentPageOffsetFraction
                                ).absoluteValue
                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    })
        }

        Spacer(modifier = Modifier.height(16.dp))
        DotsIndicator(pageCount = pageCount, pagerState = pagerState)
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
private fun RecommendedGameListPreview() {
    RecommendedGameList(
        title = stringResource(id = R.string.recommended_games),
        games = gamesDummy,
        onClickItem = {}
    )
}