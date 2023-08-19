package tech.carlosktx.freegames.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomNavigation(
    navOptions: List<NavItem>,
    itemSelected: NavItem,
    onNavItemClick: (NavItem) -> Unit
) {
    NavigationBar {
        navOptions.forEach { currentItem ->
            NavigationBarItem(
                selected = currentItem == itemSelected,
                onClick = { onNavItemClick(currentItem) },
                icon = {
                    val icon = if (currentItem == itemSelected) {
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
    BottomNavigation(navOptions = navOptions, itemSelected = NavItem.HOME, onNavItemClick = {})
}