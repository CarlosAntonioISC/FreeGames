package tech.carlosktx.freegames.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tech.carlosktx.freegames.ui.gamedetail.GameDetailScreen
import tech.carlosktx.freegames.ui.gamedetail.GameDetailViewModel
import tech.carlosktx.freegames.ui.home.HomeScreen
import tech.carlosktx.freegames.ui.home.HomeViewModel

@Composable
fun FreeGamesNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = NavCommand.ContentType(Feature.GAME).route
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