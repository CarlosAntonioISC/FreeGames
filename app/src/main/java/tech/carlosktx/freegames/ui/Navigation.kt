package tech.carlosktx.freegames.ui

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Navigation {
    val route: String
    val routeWithArgs: String
    val arguments: List<NamedNavArgument>
}

object NavigationHomeScreen : Navigation {
    override val route: String
        get() = "home"
    override val routeWithArgs: String
        get() = ""
    override val arguments: List<NamedNavArgument>
        get() = emptyList()
}

object NavigationGameDetailScreen : Navigation {

    override val route: String
        get() = "detail"
    override val routeWithArgs: String
        get() = "detail/{id}"

    val gameIdArg = NavArg("id", NavType.IntType)

    override val arguments: List<NamedNavArgument>
        get() = listOf(navArgument(gameIdArg.key) { type = gameIdArg.navType })

    fun createRouteWithArgument(gameId: Int): String {
        return "$route/$gameId"
    }

}


class NavArg(val key: String, val navType: NavType<*>)