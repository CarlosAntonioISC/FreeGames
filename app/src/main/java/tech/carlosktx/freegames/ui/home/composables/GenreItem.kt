package tech.carlosktx.freegames.ui.home.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import tech.carlosktx.freegames.R
import tech.carlosktx.freegames.domain.model.Genre
import tech.carlosktx.freegames.utils.toCapitalize

@Composable
fun GenreItem(genre: Genre) {
    Card(
        modifier = Modifier
    ) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 24.dp)
        ) {
            Icon(
                painter = painterResource(id = genre.icon),
                contentDescription = "Icon genre",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(
                        MaterialTheme.colorScheme.secondary
                    )
                    .padding(16.dp),
                tint =  MaterialTheme.colorScheme.secondaryContainer
            )
            Text(
                text = genre.name.toCapitalize,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(top = 8.dp)
            )
        }
    }
}

val Genre.icon
    get() = run {
        when (this) {
            Genre.SHOOTER -> R.drawable.ic_category_shooter
            Genre.RACING -> R.drawable.ic_category_racing
        }
    }


@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000,
    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE
)
fun GenreItemPreview() {
    GenreItem(genre = Genre.SHOOTER)
}