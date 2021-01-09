package com.ulvijabbarli.composeplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.ui.tooling.preview.Preview
import com.ulvijabbarli.composeplayground.add.AddRecipeScreen
import com.ulvijabbarli.composeplayground.feed.FeedScreen
import com.ulvijabbarli.composeplayground.home.HomeScreen
import com.ulvijabbarli.composeplayground.profile.ProfileScreen
import com.ulvijabbarli.composeplayground.search.SearchScreen
import com.ulvijabbarli.composeplayground.ui.ComposePlayGroundTheme


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlayGroundTheme {
                AppScreen()
            }
        }
    }
}

@Composable
fun AppScreen() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            ComposePlayGroundBottomNavigation(
                navController = navController,
                items = bottomNavigationItems
            )
        }
    ) {
        ComposePlayGroundMainContentConfiguration(navController)
    }
}

@Composable
private fun ComposePlayGroundMainContentConfiguration(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavigationScreens.Home.route) {
        composable(BottomNavigationScreens.Home.route) {
            HomeScreen()
        }
        composable(BottomNavigationScreens.Search.route) {
            SearchScreen()
        }
        composable(BottomNavigationScreens.Add.route) {
            AddRecipeScreen()
        }
        composable(BottomNavigationScreens.Feed.route) {
            FeedScreen()
        }
        composable(BottomNavigationScreens.Profile.route) {
            ProfileScreen()
        }
    }
}

@Composable
private fun ComposePlayGroundBottomNavigation(
    navController: NavHostController,
    items: List<BottomNavigationScreens>
) {
    BottomNavigation {
        val currentRoute = currentRoute(navController)
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(imageResource(id = screen.icon)) },
                label = { Text(stringResource(id = screen.resourceId)) },
                selected = currentRoute == screen.route,
                alwaysShowLabels = false, // This hides the title for the unselected items
                onClick = {
                    // This if check gives us a "singleTop" behavior where we do not create a
                    // second instance of the composable if we are already on that destination
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                }
            )
        }
    }
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
}

@Preview
@Composable
fun AppScreenPreview() {
    ComposePlayGroundTheme {
        AppScreen()
    }
}