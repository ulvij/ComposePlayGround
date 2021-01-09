package com.ulvijabbarli.composeplayground.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.ulvijabbarli.composeplayground.R
import com.ulvijabbarli.composeplayground.ui.ComposePlayGroundTheme

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            RecipeView()
            BreakfastView()
        }

    }
}

@Composable
fun RecipeView() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .preferredHeight(400.dp)

    ) {
        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            elevation = 4.dp
        ) {
            Box {
                Image(
                    imageResource(R.drawable.image_recipe),
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    modifier = Modifier.align(Alignment.BottomStart),
                    text = "Recipe\nof the day",
                    color = Color.White,
                    fontSize = 30.sp
                )

            }
        }
    }
}

@Composable
fun ArtistCard(
    onClick: () -> Unit
) {
    val padding = 16.dp
    Column(
        Modifier
            .clickable(onClick = onClick)
            .padding(padding)
            .fillMaxWidth()
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Alfred Sisley")
            Text("3 minutes ago")
        }
        Spacer(Modifier.preferredSize(padding))
        Card(
            modifier = Modifier.clip(RoundedCornerShape(23.dp)),
            elevation = 4.dp
        ) {
            val image = imageResource(R.drawable.image_recipe)
            Image(image)
        }
    }
}

@Composable
fun BreakfastView() {

}

@Preview
@Composable
fun HomeScreenPreview() {
    ComposePlayGroundTheme {
        HomeScreen()
    }
}

@Composable
fun FeedPreview() {
    ScrollableColumn(Modifier.fillMaxSize()) {
        repeat(10) {
            ArtistCard {
                Log.e("LOG_ITEM-->", "SELECTED-->$it")
            }
        }
    }
}