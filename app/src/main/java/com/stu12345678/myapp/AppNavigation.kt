package com.stu12345678.myapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HomePage.route,
    ) {
        composable(route = Routes.HomePage.route)
        {
            HomePage(navController = navController)
        }
        composable(route = Routes.Movie1.route)
        {
            Movie1(navController = navController)
        }
        composable(route = Routes.Movie2.route)
        {
            Movie2(navController = navController)
        }
        composable(route = Routes.Movie3.route)
        {
            Movie3(navController = navController)
        }
        composable(route = Routes.Movie4.route)
        {
            Movie4(navController = navController)
        }
    }
}
