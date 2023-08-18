package tech.carlosktx.freegames.ui.common

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteButton(isFavorite: Boolean, onClickButton: () -> Unit) {
    IconButton(onClick = { onClickButton() }) {
        Icon(
            imageVector = if (isFavorite) {
                Icons.Outlined.Favorite
            } else {
                Icons.Outlined.FavoriteBorder
            },
            contentDescription = "Mark as favorite",
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@Composable
@Preview
fun FavoriteButtonPreview() {
    FavoriteButton(isFavorite = false, onClickButton = {})
}