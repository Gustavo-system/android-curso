package com.demos.inventario.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.demos.inventario.R
import com.demos.inventario.core.navigation.ProductsRoute
import com.demos.inventario.presentation.components.CustomText
import com.demos.inventario.presentation.components.ItemHomeMenu

@Composable
fun HomeScreen(navController:NavController) {

    val icon = painterResource(id = R.drawable.ic_launcher_foreground)

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            CustomText(
                text = "Bienvenido Benito",
                textStyle = MaterialTheme.typography.displaySmall.copy(
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(14.dp))

            CustomText(
                text = "¿Que desea hacer?",
                textStyle = MaterialTheme.typography.displaySmall.copy(
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        ItemHomeMenu(
            name = "Productos",
            painter = icon,
            color = Color(0xFFFAE75F),
            onClick = {
                navController.navigate(ProductsRoute)
            }
        )
        /*Spacer(modifier = Modifier.height(14.dp))
        ItemHomeMenu("Entradas al almacen", icon, Color(0xFF5FF5FA))
        Spacer(modifier = Modifier.height(14.dp))
        ItemHomeMenu("Salidas del almacen", icon, Color(0xFF88FA5F))
        Spacer(modifier = Modifier.height(14.dp))
        ItemHomeMenu("Traspasos", icon, Color(0xFFFA5FF7))
        Spacer(modifier = Modifier.height(14.dp))
        ItemHomeMenu("Movimientos", icon, Color(0xFF5FFABC))
        Spacer(modifier = Modifier.height(14.dp))
        ItemHomeMenu("Configuracion", icon, Color(0xFFFA715F))*/
    }

}