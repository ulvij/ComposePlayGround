package com.ulvijabbarli.composeplayground

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class BottomNavigationScreens(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val icon: Int
) {
    object Home : BottomNavigationScreens("Home", R.string.home_route, R.drawable.ic_home)
    object Search : BottomNavigationScreens("Search", R.string.search_route, R.drawable.ic_search)
    object Add : BottomNavigationScreens("Add", R.string.add_route, R.drawable.ic_add_receipe)
    object Feed : BottomNavigationScreens("Feed", R.string.feed_route, R.drawable.ic_feed)
    object Profile : BottomNavigationScreens("Profile", R.string.profile_route, R.drawable.ic_profile)
}

val bottomNavigationItems = listOf(
    BottomNavigationScreens.Home,
    BottomNavigationScreens.Search,
    BottomNavigationScreens.Add,
    BottomNavigationScreens.Feed,
    BottomNavigationScreens.Profile
)