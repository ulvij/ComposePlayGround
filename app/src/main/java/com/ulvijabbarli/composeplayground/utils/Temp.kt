package com.ulvijabbarli.composeplayground

//@Composable
//fun AppScreen(
//    clickedTag: (Int) -> Unit,
//    clickedRecipe: (Int) -> Unit,
//    clickedStory: (Int) -> Unit
//) {
//    Column(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        Column {
//            StoryView(clickedStory)
//            RecipeView(clickedTag, clickedRecipe)
//        }
//    }
//}
//
//@Composable
//fun RecipeView(
//    clickedTag: (Int) -> Unit,
//    clickedRecipe: (Int) -> Unit
//) {
//    Column {
//        TagView(clickedTag)
//        LazyColumn(modifier = Modifier.padding(top = 10.dp)) {
//            items((1..20).toList()) { item ->
//                RecipeCard(item, clickedRecipe)
//            }
//        }
//    }
//}
//
//@Composable
//fun RecipeCard(item: Int, clickedRecipe: (Int) -> Unit) {
//    val image = imageResource(id = R.drawable.image_recipe)
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(250.dp)
//            .padding(10.dp)
//            .clickable { clickedRecipe(item) }
//
//    ) {
//        Card(
//            modifier = Modifier.align(Alignment.CenterHorizontally),
//            shape = RoundedCornerShape(12.dp),
//            elevation = 12.dp
//        ) {
//            Box {
//                Image(
//                    asset = image,
//                    modifier = Modifier.fillMaxSize(),
//                    contentScale = ContentScale.Crop
//                )
//                Text(
//                    modifier = Modifier
//                        .padding(start = 20.dp, bottom = 20.dp)
//                        .fillMaxWidth()
//                        .align(Alignment.BottomStart),
//                    text = "Recipe\nof the day",
//                    color = Color.White,
//                    fontSize = 30.sp
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun StoryCard(
//    item: Int,
//    modifier: Modifier = Modifier,
//    onClick: (Int) -> Unit
//) {
//    Box(
//        modifier = modifier
//            .height(100.dp)
//            .width(100.dp)
//            .padding(10.dp)
//    ) {
//        Card(
//            shape = CircleShape,
//            border = BorderStroke(1.dp, colors.random()),
//            elevation = 10.dp
//        ) {
//            val image = imageResource(R.drawable.image_recipe)
//            Image(
//                modifier = Modifier.clickable { onClick(item) },
//                asset = image,
//                contentScale = ContentScale.Crop
//            )
//        }
//
//    }
//}
//
//@Composable
//fun StoryView(clickedStory: (Int) -> Unit) {
//
//    LazyRow {
//        items((1..10).toList()) { item ->
//            StoryCard(item = item, onClick = clickedStory)
//        }
//    }
//}
//
//@Preview
//@Composable
//fun AppScreenPreview() {
//    ComposePlayGroundTheme {
//        AppScreen(
//            clickedRecipe = {
//
//            },
//            clickedStory = {
//
//            },
//            clickedTag = {
//
//            }
//        )
//    }
//}
//
//@Composable
//fun TagView(clickedItem: (Int) -> Unit) {
//    val tagItems = (1..10).toList()
//
//    LazyRow {
//        items(tagItems) { item ->
//            TagItem(item, clickedItem)
//        }
//    }
//}
//
//@Composable
//fun TagItem(item: Int, click: (Int) -> Unit) {
//    val (selected, setSelected) = remember { mutableStateOf(false) }
//
//    Column(modifier = Modifier.padding(5.dp)) {
//        Surface(
//            shape = RoundedCornerShape(6.dp),
//            elevation = 4.dp,
//            border = BorderStroke(1.dp, colors.random()),
//            modifier = Modifier.clickable {
//                setSelected(!selected)
//                click(item)
//            }
//        ) {
//            Text(
//                text = "Item $item",
//                style = TextStyle(color = Color.White),
//                modifier = Modifier
//                    .background(if (selected) Color.Red else Color.Black)
//                    .padding(horizontal = 6.dp, vertical = 4.dp)
//            )
//        }
//    }
//}