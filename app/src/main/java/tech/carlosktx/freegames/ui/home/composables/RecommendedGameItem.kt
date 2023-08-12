package tech.carlosktx.freegames.ui.home.composables

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import coil.compose.AsyncImage
import tech.carlosktx.freegames.R
import tech.carlosktx.freegames.data.dummy.gameDummy1
import tech.carlosktx.freegames.domain.model.Game

@Composable
fun RecommendedGameItem(
    game: Game,
    onClickGame: (Game) -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes placeHolderThumbnail: Int = R.drawable.plalce_holder
) {

    Card(
        modifier = modifier.fillMaxWidth().height(280.dp)
            .clip(MaterialTheme.shapes.extraLarge)
            .clickable { onClickGame(game) }
    ) {
        AsyncImage(
            model = game.thumbnail,
            placeholder = painterResource(id = placeHolderThumbnail),
            contentDescription = "${game.title} thumbnail",
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(10.dp)
                .clip(MaterialTheme.shapes.extraLarge),
            contentScale = ContentScale.Crop
        )
        Text(
            text = game.title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp, horizontal = 15.dp),
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = game.genre.name,
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp,  bottom = 20.dp, top = 5.dp)
                .clip(MaterialTheme.shapes.extraLarge)
                .background(MaterialTheme.colorScheme.secondary)
                .padding(vertical = 5.dp, horizontal = 10.dp)
            ,
            color = MaterialTheme.colorScheme.onSecondary,
            style = MaterialTheme.typography.bodyLarge,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ImportantGameItemPreview() {
    Box {
        RecommendedGameItem(
            game = gameDummy1,
            placeHolderThumbnail = R.drawable.thumbnail_dummy,
            onClickGame = {}
        )
    }
}