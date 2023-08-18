package tech.carlosktx.freegames.ui.home.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import tech.carlosktx.freegames.R
import tech.carlosktx.freegames.domain.model.Genre

@Composable
fun GenreList(genres: List<Genre>) {
    TitleSection(stringResource(id = R.string.category_games))
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(genres.size, key = { index -> genres[index].ordinal }) {
            GenreItem(genre = genres[it])
        }
    }
}