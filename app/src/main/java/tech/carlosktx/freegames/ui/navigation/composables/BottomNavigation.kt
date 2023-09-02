package tech.carlosktx.freegames.ui.navigation.composables

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import tech.carlosktx.freegames.ui.navigation.Feature
import tech.carlosktx.freegames.ui.navigation.NavCommand
import tech.carlosktx.freegames.ui.navigation.NavItem

@Composable
fun BottomNavigation(
    navOptions: List<NavItem>,
    currentRoute: String,
    onNavItemClick: (NavItem) -> Unit
) {
    NavigationBar {
        navOptions.forEach { currentItem ->
            NavigationBarItem(
                selected = currentItem.navCommand.route == currentRoute,
                onClick = { onNavItemClick(currentItem) },
                icon = {
                    val icon = if (currentItem.navCommand.route == currentRoute) {
                        currentItem.selectedIcon
                    } else {
                        currentItem.unselectedIcon
                    }
                    Icon(
                        imageVector = icon,
                        contentDescription = stringResource(id = currentItem.title)
                    )
                },
                label = {
                    Text(text = stringResource(id = currentItem.title))
                }
            )
        }
    }
}

@Composable
@Preview
fun BottomNavigationPreview() {
    val navOptions = listOf(NavItem.HOME, NavItem.FAVORITES, NavItem.SEARCHER)
    BottomNavigation(
        navOptions = navOptions,
        currentRoute = NavCommand.ContentType(Feature.GAME).route,
        onNavItemClick = {}
    )
}