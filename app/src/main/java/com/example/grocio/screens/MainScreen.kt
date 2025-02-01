package com.example.grocio.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.grocio.HomeScreen
import com.example.grocio.NotificationScreen
import com.example.grocio.ProfileScreen
import com.example.grocio.SearchScreen
import com.example.grocio.navigation.BottomNavItem

@Composable
fun MainScreen(navController: NavController) {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(bottomNavController) }
    ) { paddingValues ->
        NavHost(
            navController = bottomNavController,
            startDestination = BottomNavItem.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(BottomNavItem.Home.route) { HomeScreen() }
            composable(BottomNavItem.Search.route) { SearchScreen() }
            composable(BottomNavItem.Profile.route) { ProfileScreen() }
            composable(BottomNavItem.Notification.route) { NotificationScreen() }
        }
    }
}
