package tech.carlosktx.freegames.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BackIcon(onClickButton: () -> Unit) {
    IconButton(onClick = { onClickButton() }) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "Go back"
        )
    }
}

@Preview
@Composable
fun BackIconPreview() {
    BackIcon {}
}