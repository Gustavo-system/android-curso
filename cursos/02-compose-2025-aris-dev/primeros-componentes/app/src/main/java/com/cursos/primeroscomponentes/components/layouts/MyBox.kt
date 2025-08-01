package com.cursos.primeroscomponentes.components.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MyBox() {
    /**
     * Los box por defecto incializan a sus hijos en la parte superior izquierda
     * para modificar esto, se tiene una propiedad llamada "contentAlignment"
     *
     * El modifier solo aplica al primer hijo directo
     */
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        /**
         * No es necesario agregar las llaves si no tendras contenido
         * Se agregan las llaves si tambien se agrega la propiedad "contentAlignment"
         */
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.Red),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text("Hola mi box")
        }
    }
}