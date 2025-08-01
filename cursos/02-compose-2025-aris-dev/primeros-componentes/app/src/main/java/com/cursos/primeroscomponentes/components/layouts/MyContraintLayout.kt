package com.cursos.primeroscomponentes.components.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

/**
 * Para importar ConstraintLayout es necesario agregar la libreria en el gradle.app
 */
//@Preview(showBackground = true)
@Composable
fun MyConstraintLayout() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        // crear estas referencias solos sirven dentro del "ConstraintLayout"
        val (boxRed, boxGray, boxGreen, boxMagenta, boxYellow) = createRefs()

        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Red)
                .constrainAs(boxRed){
                    // parte-componente.lintTo(parte_componente/parte_padre)
                    top.linkTo(boxYellow.bottom)
                    start.linkTo(boxYellow.end)
                }
        )
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Gray)
                .constrainAs(boxGray){
                    top.linkTo(boxYellow.bottom)
                    end.linkTo(boxYellow.start)
                }
        )
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Green)
                .constrainAs(boxGreen){
                    bottom.linkTo(boxYellow.top)
                    start.linkTo(boxYellow.end)
                }
        )
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Magenta)
                .constrainAs(boxMagenta){
                    bottom.linkTo(boxYellow.top)
                    end.linkTo(boxYellow.start)
                }
        )
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow){
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun MyConstraintLayoutGuide() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxBlue) = createRefs()

        // creamos las guias, 0.1f es igual aun 10% 0.2f es un 20% etc...
        val guideTop = createGuidelineFromTop(0.2f)
        val guideBotton = createGuidelineFromBottom(0.3f)
        val guideStartSecondComponent = createGuidelineFromStart(0.5f)

        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    // enlazamos a nuestra guia
                    top.linkTo(guideTop)
                    start.linkTo(parent.start)
                    end.linkTo(guideStartSecondComponent)
                }
        )

        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Blue)
                .constrainAs(boxBlue) {
                    // enlazamos a nuestra guia
                    start.linkTo(guideStartSecondComponent)
                    bottom.linkTo(guideBotton)
                }
        )
    }
}



























