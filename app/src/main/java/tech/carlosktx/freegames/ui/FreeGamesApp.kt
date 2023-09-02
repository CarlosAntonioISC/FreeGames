package tech.carlosktx.freegames.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tech.carlosktx.freegames.ui.navigation.FreeGamesNavigation
import tech.carlosktx.freegames.ui.navigation.composables.BottomNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FreeGamesApp(freeGamesState: FreeGamesState = rememberFreeGamesState()) {

    Scaffold(
        bottomBar = {
            if (freeGamesState.showBottomNavigation) {
                NavigationBar {
                    BottomNavigation(
                        navOptions = FreeGamesState.BOTTOM_NAV_OPTIONS,
                        currentRoute = freeGamesState.currentRoute,
                        onNavItemClick = {
                            freeGamesState.onNavItemClick(it)
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            FreeGamesNavigation(freeGamesState.navController)
        }
    }
}