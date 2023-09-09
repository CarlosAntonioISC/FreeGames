package tech.carlosktx.freegames.ui.screens.gamedetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.carlosktx.freegames.data.dummy.gameDetailDummy1
import tech.carlosktx.freegames.ui.common.BackIcon
import tech.carlosktx.freegames.ui.common.FavoriteButton
import tech.carlosktx.freegames.ui.screens.gamedetail.composables.DetailGameDescription
import tech.carlosktx.freegames.ui.screens.gamedetail.composables.GameDetailImagesCarousel
import tech.carlosktx.freegames.ui.theme.FreeGamesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameDetailScreen(
    uiState: GameDetailUiState,
    onClickIconBack: () -> Unit,
    onClickBtnFav: () -> Unit
) {
    val scrollState = rememberScrollState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Game Detail")
                },
                navigationIcon = {
                    BackIcon(onClickButton = { onClickIconBack() })
                },
                actions = {
                    FavoriteButton(isFavorite = false, onClickButton = { onClickBtnFav() })
                },
                scrollBehavior = scrollBehavior,
            )
        }
    ) { paddingValues ->
        uiState.game?.let { gameDetail ->
            Column(
                modifier = Modifier
                    .verticalScroll(state = scrollState)
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp)
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

@Preview
@Composable
fun GameDetailScreenPreview() {
    FreeGamesTheme {
        Surface(
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        ) {
            val uiState = GameDetailUiState(game = gameDetailDummy1)
            GameDetailScreen(uiState = uiState, onClickIconBack = {}, onClickBtnFav = {})
        }
    }
}