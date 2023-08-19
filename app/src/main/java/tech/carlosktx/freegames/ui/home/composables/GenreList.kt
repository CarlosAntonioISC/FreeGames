package tech.carlosktx.freegames.ui.home.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import tech.carlosktx.freegames.R
import tech.carlosktx.freegames.domain.model.Category

@Composable
fun CategoryList(categories: List<Category>) {
    TitleSection(stringResource(id = R.string.category_games))
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(categories.size, key = { index -> categories[index].ordinal }) {
            CategoryItem(category = categories[it])
        }
    }
}