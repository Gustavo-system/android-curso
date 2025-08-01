package com.cursos.primeroscomponentes.components.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun MyColumn() {
    /**
     * Es similar a un LinearLayout, nos permite poner contenido de forma vertical
     * tenemos formas de alinear el contenido de la columna
     * verticalArrangement -> para posicionarlo de forma vertical
     * horizontalAlignment -> para posicionarlo de forma horizontal
     *
     * esto debe ir acompañado de un modifier.fillMaxSize()
     *
     * Si el contenido es demasiado que no cabe en las medidas de la pantalla
     * se puede usar la propiedad del modifier "verticalScroll(rememberScrollState())"
     */
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hola 1", modifier = Modifier.background(Color.Red))
        Text("Hola 2", modifier = Modifier.background(Color.Yellow))
        Text("Hola 3", modifier = Modifier.background(Color.Green))
        Text("Hola 4", modifier = Modifier.background(Color.Cyan))
    }
}