package tech.carlosktx.freegames.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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

    NavHost(navController = navController, startDestination = HomeScreen.route) {
        composable(HomeScreen.route) {
            val viewModel: HomeViewModel = hiltViewModel()
            val uiState = viewModel.uiState.collectAsStateWithLifecycle()
            HomeScreen(uiState.value, onClickGame = { game ->
                navController.navigate(GameDetailScreen.createRouteWithArgument(game.id))
            })
        }
        composable(
            GameDetailScreen.routeWithArgs,
            arguments = GameDetailScreen.arguments
        ) { backStackEntry ->
            val viewModel: GameDetailViewModel = hiltViewModel()
            val uiState = viewModel.uiState.collectAsStateWithLifecycle()
            val gameId = backStackEntry.arguments?.getInt(GameDetailScreen.gameIdArg.key) ?: 0
            viewModel.getGameById(gameId)
            GameDetailScreen(gameId = gameId, uiState.value)
        }
    }
}