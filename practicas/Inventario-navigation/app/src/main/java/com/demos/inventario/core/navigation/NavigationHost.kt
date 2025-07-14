package com.demos.inventario.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.demos.inventario.presentation.screens.DetailsProductScreen
import com.demos.inventario.presentation.screens.HomeScreen
import com.demos.inventario.presentation.screens.ProductScreen

@Composable
fun NavigationHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeRoute) {
        composable<HomeRoute> {
            HomeScreen(navController)
        }

        composable<ProductsRoute> {
            ProductScreen {
                productId -> navController.navigate(DetailsProductRoute(productId = productId))
            }
        }

        composable<DetailsProductRoute> { backStackEntry ->
            val detailProduct:DetailsProductRoute = backStackEntry.toRoute()
            DetailsProductScreen(detailProduct.productId)
        }
    }
}