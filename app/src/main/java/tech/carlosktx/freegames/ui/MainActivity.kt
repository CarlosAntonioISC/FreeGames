package tech.carlosktx.freegames.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import tech.carlosktx.freegames.ui.navigation.FreeGamesNavigation
import tech.carlosktx.freegames.ui.theme.FreeGamesTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FreeGamesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppWithStatusBarAndNavigationBarTheme {
                        FreeGamesNavigation()
                    }
                }
            }
        }

    }
}

@Composable
private fun AppWithStatusBarAndNavigationBarTheme(content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = !isSystemInDarkTheme()
    val color = MaterialTheme.colorScheme.background
    SideEffect {
        systemUiController.setStatusBarColor(
            color = color,
            darkIcons = useDarkIcons
        )
        systemUiController.setNavigationBarColor(
            color = color,
            darkIcons = useDarkIcons
        )
    }
    content()
}