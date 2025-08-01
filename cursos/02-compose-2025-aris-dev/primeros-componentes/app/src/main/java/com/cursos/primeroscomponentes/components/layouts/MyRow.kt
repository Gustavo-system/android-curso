package com.cursos.primeroscomponentes.components.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun MyRow() {
    /**
     * Para las filas tenemos
     * horizontalArrangement
     *
     * para las filas podemos usar fillMaxSize() o fillMaxWidth()
     *
     * para el tema de las filas se usa el horizontalScroll(rememberScrollState())
     */
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Yellow))
        Text("Hola 3", modifier = Modifier.background(Color.Green))
        Text("Hola 4", modifier = Modifier.background(Color.Cyan))
    }
}
