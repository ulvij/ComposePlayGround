package com.ulvijabbarli.composeplayground.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.ulvijabbarli.composeplayground.R
import com.ulvijabbarli.composeplayground.ui.lightBlue

@Composable
fun SearchView(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(color = lightBlue)
            .padding(horizontal = 14.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        var text by remember { mutableStateOf(TextFieldValue()) }
        TextField(
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(fontSize = 12.sp),
            value = text,
            onValueChange = { text = it },
            inactiveColor = Color.Transparent,
            maxLines = 1,
            placeholder = {
                Text(
                    text = "Search places ...",
                    style = TextStyle(color = Color.Gray)
                )
            },
            backgroundColor = lightBlue,
            trailingIcon = { Image(asset = vectorResource(id = R.drawable.ic_search)) })
    }
}

@Preview
@Composable
fun SearchViewPreview() {
    MaterialTheme {
        SearchView()
    }
}