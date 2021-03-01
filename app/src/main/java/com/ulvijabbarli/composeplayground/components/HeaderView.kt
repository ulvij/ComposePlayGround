package com.ulvijabbarli.composeplayground.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ulvijabbarli.composeplayground.R
import com.ulvijabbarli.composeplayground.ui.lightBlue

@Composable
fun HeaderView() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            LocationView()
            ProfileView()
        }
        Spacer(modifier = Modifier.padding(16.dp))
        Text(
            text = "Welcome to USA, Georgia!",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun LocationView() {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(14.dp))
            .background(lightBlue)
            .height(50.dp)
            .padding(vertical = 14.dp, horizontal = 10.dp)
    ) {
        Image(asset = vectorResource(R.drawable.ic_location), modifier = Modifier.size(20.dp))
        Spacer(modifier = Modifier.padding(6.dp))
        Text(text = "Chicago, USA")
    }
}

@Composable
fun ProfileView() {
    Card(
        modifier = Modifier.size(50.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = 16.dp,
    ) {
        Image(
            asset = imageResource(id = R.drawable.image_recipe),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun LocationViewPreview() {
    MaterialTheme {
        LocationView()
    }
}