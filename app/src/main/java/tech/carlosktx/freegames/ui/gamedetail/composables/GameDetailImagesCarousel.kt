package tech.carlosktx.freegames.ui.gamedetail.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import tech.carlosktx.freegames.R
import tech.carlosktx.freegames.ui.common.DotsIndicator

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GameDetailImagesCarousel(
    images: List<String>,
    modifier: Modifier = Modifier
) {
    val pageCount = images.size
    val pagerState = rememberPagerState()
    Column {
        HorizontalPager(
            modifier = modifier,
            pageCount = pageCount,
            state = pagerState,
            pageSpacing = 16.dp
        ) { page ->
            AsyncImage(
                model = images[page],
                placeholder = painterResource(id = R.drawable.plalce_holder),
                contentDescription = "thumbnail",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)
                    .clip(MaterialTheme.shapes.extraLarge),
                contentScale = ContentScale.Crop
            )
        }
        DotsIndicator(pageCount, pagerState)
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF000000
)
@Composable
fun GameDetailImagesCarouselPreview() {
    GameDetailImagesCarousel(List(3) { "" })
}