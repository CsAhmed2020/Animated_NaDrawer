package com.example.demob.navigation

sealed class Screen(val route: String) {

    object HomeScreen : Screen("home_screen")
    object TasksScreen : Screen("tasks_screen")
    object LiveScreen : Screen("live_screen")
    object CallScreen : Screen("call_screen")
    }


