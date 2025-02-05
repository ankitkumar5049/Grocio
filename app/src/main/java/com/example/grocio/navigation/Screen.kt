package com.example.grocio.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String) {
     object Login: Screen("login_screen")
     object Main: Screen("main_screen")
}

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
     object Home : BottomNavItem("home", Icons.Default.Home, "Home")
     object Search : BottomNavItem("search", Icons.Default.Search, "Search")
     object Profile : BottomNavItem("profile", Icons.Default.Person, "Profile")
     object Notification : BottomNavItem("dashboard", Icons.Default.Notifications, "Notification")
}
