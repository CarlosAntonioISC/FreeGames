package tech.carlosktx.freegames.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import tech.carlosktx.freegames.ui.gamedetail.GameDetailScreen
import tech.carlosktx.freegames.ui.gamedetail.GameDetailViewModel
import tech.carlosktx.freegames.ui.home.HomeScreen
import tech.carlosktx.freegames.ui.home.HomeViewModel
import tech.carlosktx.freegames.ui.theme.FreeGamesTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreeGamesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FreeGamesApp()
                }
            }
        }
    }
}

@Composable
fun FreeGamesApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            val viewModel: HomeViewModel = hiltViewModel()
            val state = viewModel.uiState.collectAsStateWithLifecycle()
            HomeScreen(state.value, onClickGame = { game ->
                navController.navigate("detail/${game.id}")
            })
        }
        composable(
            "detail/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val viewModel: GameDetailViewModel = hiltViewModel()
            val state = viewModel.uiState.collectAsStateWithLifecycle()
            val gameId = backStackEntry.arguments?.getInt("id") ?: 0
            viewModel.getGameById(gameId)
            GameDetailScreen(gameId = gameId, state.value)
        }
    }
}