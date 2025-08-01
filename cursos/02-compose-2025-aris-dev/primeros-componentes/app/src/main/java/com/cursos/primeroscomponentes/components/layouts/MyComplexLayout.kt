package com.cursos.primeroscomponentes.components.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MyComplexLayout() {
    Column {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.Red)
                .fillMaxWidth()
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.Blue)
                .fillMaxWidth()
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(125.dp)
                        .background(Color.Yellow),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Text(text = "Hola")
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(185.dp)
                        .background(Color.Green),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Adios")
                }
            }
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.Magenta)
                .fillMaxSize()
        )
    }
}