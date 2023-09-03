package tech.carlosktx.freegames.ui.screens.home.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import tech.carlosktx.freegames.R
import tech.carlosktx.freegames.domain.model.Category
import tech.carlosktx.freegames.utils.toCapitalize

@Composable
fun CategoryItem(category: Category, modifier: Modifier = Modifier) {

    Card(
        modifier = modifier.fillMaxHeight()
    ) {
        Icon(
            painter = painterResource(id = category.icon),
            contentDescription = "Icon category",
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 10.dp)
                .fillMaxSize()
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.secondary)
                .align(Alignment.CenterHorizontally)
                .weight(0.65f)
                .padding(8.dp),
            tint = MaterialTheme.colorScheme.secondaryContainer
        )
        Text(
            text = category.name.toCapitalize,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(0.35f)
                .wrapContentHeight(),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

val Category.icon
    get() = run {
        when (this) {
            Category.SHOOTER -> R.drawable.ic_category_shooter
            Category.RACING -> R.drawable.ic_category_racing
            Category.SPORTS -> R.drawable.ic_category_sports
            Category.BATTLE_ROYALE -> R.drawable.ic_category_battle_royale
            Category.CARDS -> R.drawable.ic_category_cards
            Category.FIGHTING -> R.drawable.ic_category_fighting
            Category.MMORPG -> R.drawable.ic_category_mmorpg
            Category.SOCIAL -> R.drawable.ic_category_social
            Category.MMOARPG -> R.drawable.ic_category_mmoarpg
            Category.ARPG -> R.drawable.ic_category_arpg
            Category.STRATEGY -> R.drawable.ic_category_strategy
            Category.ACTION_RPG -> R.drawable.ic_action_action_rpg
            Category.MOBA -> R.drawable.ic_category_moba
            Category.UNKNOWN -> R.drawable.ic_category_unknown
        }
    }


@Composable
@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000,
    wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE,
    heightDp = 200
)
fun CategoryItemPreview() {
    CategoryItem(category = Category.SHOOTER)
}