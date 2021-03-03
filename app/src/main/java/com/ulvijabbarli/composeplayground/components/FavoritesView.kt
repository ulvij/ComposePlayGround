package com.ulvijabbarli.composeplayground.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableRow
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ulvijabbarli.composeplayground.R
import com.ulvijabbarli.composeplayground.ui.*

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
        LazyRow(contentPadding = PaddingValues(start = 15.dp, end = 15.dp, bottom = 15.dp)) {
            items((1..10).toList()) { item ->
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
            .width(210.dp)
            .height(260.dp)
            .padding(5.dp),
        elevation = 10.dp
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                asset = imageResource(id = R.drawable.image_favorite),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(transparentBy10)
                        .padding(horizontal = 10.dp, vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(asset = vectorResource(id = R.drawable.ic_park), tint = Color.White)
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(text = "Parks", color = Color.White, fontSize = 10.sp)
                }

                FavoriteDetailItem(item = item, radius = cornerRadius)
            }
        }
    }
}

@Composable
fun FavoriteDetailItem(item: Int, radius: Dp) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(radius))
            .fillMaxWidth()
            .height(100.dp)
            .background(whiteTransparentBy64)
            .padding(horizontal = 10.dp, vertical = 5.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Lincoln Park", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(vectorResource(id = R.drawable.ic_location_grey))
                Spacer(modifier = Modifier.padding(2.dp))
                Text(
                    text = "34 West 57th Street, PH",
                    fontSize = 14.sp,
                    color = Color.Black,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(text = "9.8 mi", fontSize = 12.sp, color = Color.Gray)
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(color = white)
                    .padding(horizontal = 10.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "Detail",
                    color = blueLight,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}