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


@Preview(showBackground = true)
@Composable
fun ExerciseTwo() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxCyan, boxBlack, boxDarkBlack, boxMagenta, boxGreen, boxYellow, boxGray, boxBlue, boxRed) = createRefs()

        Box(modifier = Modifier
            .size(175.dp)
            .background(Color.Cyan)
            .constrainAs(boxCyan){
                bottom.linkTo(boxMagenta.top)
                end.linkTo(boxMagenta.end)
            }
        )
        Box(modifier = Modifier
            .size(175.dp)
            .background(Color.DarkGray)
            .constrainAs(boxDarkBlack){
                bottom.linkTo(boxGreen.top)
                start.linkTo(boxGreen.start)
            }
        )
        Box(modifier = Modifier
            .size(175.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue){
                top.linkTo(boxYellow.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Black)
            .constrainAs(boxBlack){
                start.linkTo(boxCyan.end)
                top.linkTo(boxCyan.top)
                bottom.linkTo(boxCyan.bottom)
                end.linkTo(boxDarkBlack.start)
            }
        )
        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta){
                bottom.linkTo(boxYellow.top)
                end.linkTo(boxYellow.start)
            }
        )
        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Green)
            .constrainAs(boxGreen){
                bottom.linkTo(boxYellow.top)
                start.linkTo(boxYellow.end)
            }
        )
        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow){
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        )
        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Gray)
            .constrainAs(boxGray){
                top.linkTo(boxYellow.bottom)
                end.linkTo(boxYellow.start)
            }
        )
        Box(modifier = Modifier
            .size(75.dp)
            .background(Color.Red)
            .constrainAs(boxRed){
                top.linkTo(boxYellow.bottom)
                start.linkTo(boxYellow.end)
            }
        )
    }
}