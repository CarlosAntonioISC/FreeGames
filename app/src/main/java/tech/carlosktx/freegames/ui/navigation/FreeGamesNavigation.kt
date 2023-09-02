package tech.carlosktx.freegames.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import tech.carlosktx.freegames.ui.screens.favorites.FavoritesScreen
import tech.carlosktx.freegames.ui.screens.gamedetail.GameDetailScreen
import tech.carlosktx.freegames.ui.screens.gamedetail.GameDetailViewModel
import tech.carlosktx.freegames.ui.screens.home.HomeScreen
import tech.carlosktx.freegames.ui.screens.home.HomeViewModel
import tech.carlosktx.freegames.ui.screens.searcher.SearcherScreen

@Composable
fun FreeGamesNavigation(navController: NavHostController) {

    NavHost(
        navController = navController, startDestination = Feature.GAME.route
    ) {
        navigation(
            route = Feature.GAME.route,
            startDestination = NavCommand.ContentType(Feature.GAME).route
        ) {
            composable(NavCommand.ContentType(Feature.GAME)) {
                val viewModel: HomeViewModel = hiltViewModel()
                val uiState = viewModel.uiState.collectAsStateWithLifecycle()
                HomeScreen(uiState.value, onClickGame = { game ->
                    navController.navigate(
                        NavCommand.ContentTypeDetail(Feature.GAME).createRoute(game.id)
                    )
                })
            }
            composable(NavCommand.ContentTypeDetail(Feature.GAME)) {
                val viewModel: GameDetailViewModel = hiltViewModel()
                val uiState = viewModel.uiState.collectAsStateWithLifecycle()
                GameDetailScreen(
                    uiState.value,
                    onClickIconBack = {
                        navController.popBackStack()
                    }
                )
            }
        }

        navigation(
            route = Feature.FAVORITES.route,
            startDestination = NavCommand.ContentType(Feature.FAVORITES).route
        ) {
            composable(NavCommand.ContentType(Feature.FAVORITES)) {
                FavoritesScreen()
            }
        }

        navigation(
            route = Feature.SEARCHER.route,
            startDestination = NavCommand.ContentType(Feature.SEARCHER).route
        ) {
            composable(NavCommand.ContentType(Feature.SEARCHER)) {
                SearcherScreen()
            }
        }

    }
}

private fun NavGraphBuilder.composable(
    navCommand: NavCommand,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navCommand.route,
        arguments = navCommand.args
    ) {
        content(it)
    }
}