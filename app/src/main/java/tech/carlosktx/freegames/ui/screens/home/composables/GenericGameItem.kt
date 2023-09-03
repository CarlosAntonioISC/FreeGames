package tech.carlosktx.freegames.ui.screens.home.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import tech.carlosktx.freegames.R
import tech.carlosktx.freegames.data.dummy.gameDummy1
import tech.carlosktx.freegames.domain.model.Game

@Composable
fun GenericGameItem(
    game: Game,
    onClickGame: (Game) -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes placeHolderThumbnail: Int = R.drawable.plalce_holder
) {
    Column(
        modifier = modifier
            .width(140.dp)
            .clip(MaterialTheme.shapes.small)
            .clickable { onClickGame(game) }
    ) {
        AsyncImage(
            model = game.thumbnail,
            placeholder = painterResource(id = placeHolderThumbnail),
            contentDescription = "${game.title} thumbnail",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(MaterialTheme.shapes.small),
            contentScale = ContentScale.Crop
        )
        Text(
            text = game.title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp),
            style = MaterialTheme.typography.labelMedium,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}


@Preview(
    showBackground = true,
    heightDp = 300
)
@Composable
private fun GenericGameItemPreview() {
    GenericGameItem(
        game = gameDummy1,
        placeHolderThumbnail = R.drawable.thumbnail_dummy,
        onClickGame = {},
        modifier = Modifier.fillMaxHeight()
    )
}