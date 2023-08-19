package tech.carlosktx.freegames.ui

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

enum class Feature(val route: String) {
    GAME("game"),
    FAVORITES("favorites"),
    SEARCHER("searcher"),
}

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


sealed class NavCommand(
    internal val feature: Feature,
    internal val subRoute: String = "home",
    private val navArgs: List<NavArg> = emptyList()
) {
    class ContentType(feature: Feature) : NavCommand(feature)

    class ContentTypeDetail(feature: Feature) :
        NavCommand(feature, "detail", listOf(NavArg.ItemId)) {
        fun createRoute(itemId: Int) = "${feature.route}/$subRoute/$itemId"
    }

    val route = run {
        val argValues = navArgs.map { "{${it.key}}" }
        listOf(feature.route)
            .plus(subRoute)
            .plus(argValues)
            .joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }

}

enum class NavArg(val key: String, val navType: NavType<*>) {
    ItemId("itemId", NavType.IntType)
}