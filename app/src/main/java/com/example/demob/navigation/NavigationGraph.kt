package com.example.demob.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.demob.HomeScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable




@ExperimentalAnimationApi
@ExperimentalMaterial3Api
@Composable
fun NavigationGraph(navController: NavHostController) {
    AnimatedNavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.TasksScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.LiveScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.CallScreen.route){
            HomeScreen(navController = navController)
        }
    }
}
