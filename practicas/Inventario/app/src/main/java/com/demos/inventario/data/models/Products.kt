package com.demos.inventario.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Products(
    val id: String,
    val nombre: String,
    val precio: String,
    val imagenResId: Int
)