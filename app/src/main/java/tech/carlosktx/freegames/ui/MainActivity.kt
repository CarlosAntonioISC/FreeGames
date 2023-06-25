package tech.carlosktx.freegames.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
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
                    val state = viewModel.uiState.collectAsStateWithLifecycle()
                    HomeScreen(state.value) {}

                }
            }
        }
    }
}