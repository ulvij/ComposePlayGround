package com.ulvijabbarli.composeplayground.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ulvijabbarli.composeplayground.R
import com.ulvijabbarli.composeplayground.ui.lightBlue
import com.ulvijabbarli.composeplayground.ui.surface

@Composable
fun NearestView(header: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .background(color = surface)
            .fillMaxWidth()
    ) {
        NearestList(header)
    }
}

@Composable
fun NearestList(header: @Composable ColumnScope.() -> Unit) {
    LazyColumn(
    ) {
        item {
            ColumnScope.header()
            Text(
                text = "Nearest Places",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(start = 20.dp)
            )
        }
        items((1..10).toList()) {
            NearestItem()
        }
    }
}

@Composable
fun NearestItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = 4.dp
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Card(
                modifier = Modifier.size(60.dp),
                shape = RoundedCornerShape(6.dp),
                elevation = 16.dp,
            ) {
                Image(
                    asset = imageResource(id = R.drawable.image_nearest),
                    contentScale = ContentScale.Fit
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(10.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(vectorResource(id = R.drawable.ic_bed))
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(
                        text = "Royal Albert Hotel",
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Text(
                    text = "231 East 95th Street, HK",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "9.8 mi", fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
}