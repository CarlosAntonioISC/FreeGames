package tech.carlosktx.freegames.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import tech.carlosktx.freegames.domain.model.Genre

@Composable
fun TextGenre(genre: Genre) {
    Text(
        text = genre.name,
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp)
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