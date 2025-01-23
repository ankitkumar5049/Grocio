package com.example.grocio.navigation

sealed class Screen(val route: String) {
     object Dashboard : Screen("dashboard")

     object shopsScreen : Screen("shopsScreen") {
          fun createRoute(): String = "shopsScreen"
     }
}
