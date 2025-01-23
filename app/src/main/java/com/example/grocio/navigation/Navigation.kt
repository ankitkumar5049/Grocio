package com.example.grocio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation(){
    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = Screen.Dashboard.route) {
//        composable(route = Screen.Dashboard.route) {
//            MovieListScreen(navController, getHardcodedMovies(), onLanguageChange = {})
//        }
//        composable(
//            route = Screen.DetailScreen.route,
//            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
//        ) { backStackEntry ->
//            val movieId = backStackEntry.arguments?.getInt("movieId") ?: -1
//            MovieDetailScreen(movieId)
//        }
//    }
}