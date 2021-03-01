package com.ulvijabbarli.composeplayground.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ulvijabbarli.composeplayground.R

@Composable
fun FavoritesView() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Favorite Places",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(start = 20.dp)
        )
        LazyRow(contentPadding = PaddingValues(start = 15.dp, end = 15.dp, bottom = 10.dp)) {
            items((1..20).toList()) { item ->
                FavoriteItem(item)
            }
        }
    }
}

@Composable
fun FavoriteItem(item: Int) {
    val cornerRadius = 16.dp

    Card(
        shape = RoundedCornerShape(cornerRadius),
        modifier = Modifier
            .width(160.dp)
            .height(200.dp)
            .padding(5.dp),
        elevation = 10.dp
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                asset = imageResource(id = R.drawable.image_favorite),
                contentScale = ContentScale.Crop
            )
            FavoriteDetailItem(item = item, cornerRadius)
        }
    }
}

@Composable
fun FavoriteDetailItem(item: Int, radius: Dp) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .background(Color.White)
            .clip(RoundedCornerShape(radius))
            .fillMaxWidth()
            .height(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

    }
}