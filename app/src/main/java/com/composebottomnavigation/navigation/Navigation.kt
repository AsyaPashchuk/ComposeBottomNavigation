package com.composebottomnavigation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.composebottomnavigation.screens.ChatScreen
import com.composebottomnavigation.screens.HomeScreen
import com.composebottomnavigation.screens.SettingScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen()
        }
        composable("chat") {
            ChatScreen()
        }
        composable("settings") {
            SettingScreen()
        }
    }
}