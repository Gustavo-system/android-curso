package com.demos.inventario.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailsProductScreen(productId:String) {

    Text(
        text = "detalle del producto con id $productId"
    )

}