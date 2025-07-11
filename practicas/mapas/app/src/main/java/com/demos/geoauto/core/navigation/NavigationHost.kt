package com.demos.geoauto.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.demos.geoauto.presentation.screens.HomeScreen
import com.demos.geoauto.presentation.screens.LoginScreen
import com.demos.geoauto.presentation.screens.MisAutosScreen

@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login) {

        composable<Login> {
            LoginScreen()
        }

        composable<Home> {
            HomeScreen()
        }

        composable<MisAutos> {
            MisAutosScreen()
        }
    }
}