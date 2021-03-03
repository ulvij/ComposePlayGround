package com.ulvijabbarli.composeplayground

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.ulvijabbarli.composeplayground.components.FavoritesView
import com.ulvijabbarli.composeplayground.components.HeaderView
import com.ulvijabbarli.composeplayground.components.NearestView
import com.ulvijabbarli.composeplayground.components.SearchView


@Composable
fun AppScreen() {
    Column{
        HeaderView()
        SearchView()
        FavoritesView()
    }
}
