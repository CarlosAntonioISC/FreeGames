package tech.carlosktx.freegames.ui

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import tech.carlosktx.freegames.ui.navigation.NavItem
import tech.carlosktx.freegames.utils.navigatePoppingUpToStartDestination

@Composable
fun rememberFreeGamesState(
    navController: NavHostController = rememberNavController()
): FreeGamesState {
    return remember(navController) {
        FreeGamesState(navController)
    }
}

class FreeGamesState(val navController: NavHostController) {

    companion object {
        val BOTTOM_NAV_OPTIONS = listOf(NavItem.HOME, NavItem.FAVORITES, NavItem.SEARCHER)
    }

    val currentRoute: String
        @Composable get() = (navController.currentBackStackEntryAsState().value?.destination?.route
            ?: "").also {
            Log.d("carloss current route", it)
        }

    val showBottomNavigation: Boolean
        @Composable get() = BOTTOM_NAV_OPTIONS.any { currentRoute.contains(it.navCommand.feature
            .route) }.also {
            Log.d("carloss shoe bottom navigation", "$it")
        }

    fun onNavItemClick(navItem: NavItem) {
        navController.navigatePoppingUpToStartDestination(navItem.navCommand.route)
    }

}