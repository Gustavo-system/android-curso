package com.demos.inventario.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.demos.inventario.R
import com.demos.inventario.data.models.Products

@Composable
fun ProductScreen(navigateToDetail: (String) -> Unit){
    val products = listOf(
        Products("1", "Camiseta Negra", "$250 MXN", R.drawable.ic_launcher_foreground),
        Products("2","Zapatos Deportivos", "$1,200 MXN", R.drawable.ic_launcher_foreground),
        Products("3","Gorra Roja", "$180 MXN", R.drawable.ic_launcher_foreground),
        Products("4","Playera", "$180 MXN", R.drawable.ic_launcher_foreground),
        Products("5","Reloj", "$180 MXN", R.drawable.ic_launcher_foreground),
        Products("6","Gafas", "$180 MXN", R.drawable.ic_launcher_foreground),
        Products("7","Calcetines", "$180 MXN", R.drawable.ic_launcher_foreground),
        Products("8","Camisa", "$180 MXN", R.drawable.ic_launcher_foreground),
    )

    ListProducts(products = products, navigateTo = navigateToDetail)
}


@Composable
fun ListProducts(products: List<Products>, navigateTo: (String) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(products) { product ->
            ProductItem(
                product = product,
                onClick = {
                    navigateTo(product.id)
                }
            )
        }
    }
}

@Composable
fun ProductItem(product: Products, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .clickable {
                onClick()
            }
            .padding(8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .clickable {

                }
        ) {
            Image(
                painter = painterResource(id = product.imagenResId),
                contentDescription = product.nombre,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = product.nombre,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = product.precio,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}