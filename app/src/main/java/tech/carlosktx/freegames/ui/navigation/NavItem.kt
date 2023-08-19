package tech.carlosktx.freegames.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import tech.carlosktx.freegames.R

enum class NavItem(
    val navCommand: NavCommand,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    @StringRes val title: Int
) {
    HOME(
        NavCommand.ContentType(Feature.GAME),
        Icons.Filled.Home,
        Icons.Outlined.Home, R.string.home
    ),
    FAVORITES(
        NavCommand.ContentType(Feature.FAVORITES),
        Icons.Filled.Favorite,
        Icons.Outlined.Favorite,
        R.string.favorites
    ),
    SEARCHER(
        NavCommand.ContentType(Feature.SEARCHER),
        Icons.Filled.Search,
        Icons.Outlined.Search,
        R.string.search
    )
}