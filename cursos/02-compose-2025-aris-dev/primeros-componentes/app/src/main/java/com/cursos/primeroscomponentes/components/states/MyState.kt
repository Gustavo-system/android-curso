package com.cursos.primeroscomponentes.components.states

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun MyDemoState(modifier: Modifier) {

    /* esto funciona para guardar el estado y hacer modificaciones de los valores
     * si giramos la pantalla esto regresa a su valor inicial
     * debemos acceder al .value
     * podemos declararlos como val por que no se usa la variable ya que accedemos al .value
     */
    var numberRemember = remember { mutableStateOf(0) }

    /*
     * esto funciona para recordar el estado cuando se gira la pantalla
     * debemos acceder al .value
     * podemos declararlos como val por que no se usa la variable ya que accedemos al .value
     */
    var numberSaveable = rememberSaveable { mutableStateOf(0) }

    /*
     * De esta forma ya no requerimos el .value
     * Debemos colocarlo como var por que ahora si se modifica la variable
     * debemos importar androidx.compose.runtime.getValue
     * debemos importar androidx.compose.runtime.setValue
     */
    var numberBy by rememberSaveable { mutableStateOf(0) }


    Column(modifier = modifier) {
        Text(
            "Haz click sobre mi (remember): ${numberRemember.value}",
            modifier = modifier.clickable { numberRemember.value += 1 })
        Text(
            "Haz click sobre mi (saveable): ${numberSaveable.value}",
            modifier = modifier.clickable { numberSaveable.value += 1 })
        Text(
            "Haz click sobre mi (saveable and by): $numberBy",
            modifier = modifier.clickable { numberBy += 1 })

        // funte unica de la verdad, es decir el padre se encarga de la logica y se pasa como lambda
        FuenteDeLaVerdad1(numberBy) { numberBy += 1 }
        FuenteDeLaVerdad2(number = numberBy, onClick = {numberBy += 2})
    }
}


@Composable
fun FuenteDeLaVerdad1(number:Int, onClick: () -> Unit) {
    Text(
        "Haz click sobre mi (State Hosting 1): $number",
        modifier = Modifier.clickable { onClick() })
}

@Composable
fun FuenteDeLaVerdad2(number:Int, onClick: () -> Unit) {
    Text(
        "Haz click sobre mi (State Hosting 2): $number",
        modifier = Modifier.clickable { onClick() })
}