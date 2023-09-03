package tech.carlosktx.freegames.ui.screens.home.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import tech.carlosktx.freegames.R
import tech.carlosktx.freegames.data.dummy.gameDummy1
import tech.carlosktx.freegames.domain.model.Game
import tech.carlosktx.freegames.ui.common.TextCategory

@Composable
fun RecommendedGameItem(
    game: Game,
    onClickGame: (Game) -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes placeHolderThumbnail: Int = R.drawable.plalce_holder
) {
    Card(
        modifier = modifier
            .fillMaxSize()
            .clip(MaterialTheme.shapes.extraLarge)
            .clickable { onClickGame(game) }
    ) {
        AsyncImage(
            model = game.thumbnail,
            placeholder = painterResource(id = placeHolderThumbnail),
            contentDescription = "${game.title} thumbnail",
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .weight(1f)
                .clip(MaterialTheme.shapes.extraLarge),
            contentScale = ContentScale.Crop
        )
        Text(
            text = game.title,
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .fillMaxWidth(),
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        TextCategory(
            game.category, modifier = Modifier.padding(
                start = 15.dp,
                end = 15.dp,
                bottom = 10.dp,
                top = 5.dp
            )
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true, heightDp = 500)
private fun ImportantGameItemPreview() {
    Box {
        RecommendedGameItem(
            game = gameDummy1,
            placeHolderThumbnail = R.drawable.thumbnail_dummy,
            onClickGame = {}
        )
    }
}