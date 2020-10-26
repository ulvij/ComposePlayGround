package com.ulvijabbarli.composeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Layout
import androidx.compose.ui.Modifier
import androidx.compose.ui.WithConstraints
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.ulvijabbarli.composeplayground.ui.ComposePlayGroundTheme

val topics = listOf(
    "Arts & Crafts", "Beauty", "Books", "Business", "Comics", "Culinary",
    "Design", "Fashion", "Film", "History", "Maths", "Music", "People", "Philosophy",
    "Religion", "Social sciences", "Technology", "TV", "Writing"
)

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlayGroundTheme {
                ComposePlayGround()
            }
        }
    }
}

@Composable
fun ComposePlayGround() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "ComposePlayGround") }, actions =
            {
                IconButton(onClick = { }) {
                    Icon(Icons.Filled.Favorite)
                }
            })
        }
    ) { innerPadding ->
        BodyContent(Modifier.padding(innerPadding))
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    ScrollableRow(modifier = modifier) {
        StaggeredGrid {
            for (topic in topics) {
                Chip(Modifier.padding(8.dp), text = topic)
            }
        }
    }
}

//@Preview
//@Composable
//fun ComposePlayGroundPreview() {
//    ComposePlayGroundTheme {
//        ComposePlayGround()
//    }
//}


@Composable
fun StaggeredGrid(
    modifier: Modifier = Modifier,
    rows: Int = 3,
    children: @Composable() () -> Unit
) {
    Layout(
        modifier = modifier,
        children = children
    ) { measurables, constraints ->

        val rowWidths = IntArray(rows) { 0 }

        val rowMaxHeights = IntArray(rows) { 0 }

        val placeables = measurables.mapIndexed { index, measurable ->

            val placeable = measurable.measure(constraints)

            val row = index % rows
            rowWidths[row] = rowWidths[row] + placeable.width
            rowMaxHeights[row] = maxOf(rowMaxHeights[row], placeable.height)

            placeable
        }

        val width = rowWidths.maxOrNull()
            ?.coerceIn(constraints.minWidth.rangeTo(constraints.maxWidth)) ?: constraints.minWidth

        val height = rowMaxHeights.sumBy { it }
            .coerceIn(constraints.minHeight.rangeTo(constraints.maxHeight))

        val rowY = IntArray(rows) { 0 }
        for (i in 1 until rows) {
            rowY[i] = rowY[i - 1] + rowMaxHeights[i - 1]
        }

        layout(width, height) {

            val rowX = IntArray(rows) { 0 }

            placeables.forEachIndexed { index, placeable ->
                val row = index % rows
                placeable.placeRelative(x = rowX[row], y = rowY[row])
                rowX[row] += placeable.width
            }
        }
    }
}

@Composable
fun Chip(modifier: Modifier = Modifier, text: String) {
    Card(
        modifier = modifier,
        border = BorderStroke(color = Color.Black, width = Dp.Hairline),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.preferredSize(16.dp, 16.dp)
                    .background(color = MaterialTheme.colors.secondary)
            )
            Spacer(modifier = Modifier.preferredSize(4.dp))
            Text(text = text)
        }
    }
}

//@Preview
//@Composable
//fun ChipPreview() {
//    ComposePlayGroundTheme {
//        Chip(text = "Hi There")
//    }
//}

@Composable
fun ConstraintLayoutContent() {
    WithConstraints {

        val constraints = if (minWidth < 600.dp) {
            decoupledConstraints(16.dp)
        } else {
            decoupledConstraints(32.dp)
        }

        ConstraintLayout(constraints) {
            Button(
                onClick = { /* Do something */ },
                modifier = Modifier.layoutId("button")
            ) {
                Text("Button")
            }

            Text(
                text = "This is a very very very very very very very long text",
                Modifier.layoutId("text")
            )
        }
    }
}

@Preview
@Composable
fun ConstraintLayoutContentPreview() {
    ComposePlayGroundTheme {
        ConstraintLayoutContent()
    }
}

private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val button = createRefFor("button")
        val text = createRefFor("text")
        constrain(button) {
            top.linkTo(parent.top, margin = margin)
        }

        constrain(text) {
            top.linkTo(button.bottom, margin = margin)
        }
    }
}