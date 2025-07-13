package com.demos.inventario.core.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

@Serializable
object ProductsRoute

@Serializable
data class DetailsProductRoute(
    val productId: String
)
