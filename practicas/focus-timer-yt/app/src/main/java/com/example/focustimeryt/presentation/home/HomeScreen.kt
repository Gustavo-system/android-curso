package com.example.focustimeryt.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.focustimeryt.R
import com.example.focustimeryt.presentation.components.AutoResizedText
import com.example.focustimeryt.presentation.components.BorderIcons
import com.example.focustimeryt.presentation.components.CircleDot
import com.example.focustimeryt.presentation.components.CustomButton
import com.example.focustimeryt.presentation.components.TimerTypeItem
import com.example.focustimeryt.presentation.theme.FocusTimerYTTheme

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(FocusTimerYTTheme.dimens.paddingMedium)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopEnd
        ) {
            Icon(
                modifier = Modifier.size(FocusTimerYTTheme.dimens.iconSizeNormal),
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = "Menu",
                tint = MaterialTheme.colorScheme.primary
            )
        }

        AutoResizedText(
            text = "Focus Timer",
            textStyle = MaterialTheme.typography.displayMedium.copy(
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.height(FocusTimerYTTheme.dimens.spacerMedium))

        Row {
            CircleDot()
            Spacer(modifier = Modifier.width(FocusTimerYTTheme.dimens.spacerNormal))
            CircleDot()
            Spacer(modifier = Modifier.width(FocusTimerYTTheme.dimens.spacerNormal))
            CircleDot(
                color = MaterialTheme.colorScheme.tertiary
            )
            Spacer(modifier = Modifier.width(FocusTimerYTTheme.dimens.spacerNormal))
            CircleDot(
                color = MaterialTheme.colorScheme.tertiary
            )
        }

        Spacer(modifier = Modifier.height(FocusTimerYTTheme.dimens.spacerMedium))

        TimerSession(timer = "15:00")

        Spacer(modifier = Modifier.height(FocusTimerYTTheme.dimens.spacerMedium))

        TimerTypeSession()

        Spacer(modifier = Modifier.height(FocusTimerYTTheme.dimens.spacerMedium))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CustomButton(
                text = "Start",
                textColor = MaterialTheme.colorScheme.surface,
                buttonColor = MaterialTheme.colorScheme.primary
            )
            CustomButton(
                text = "Reset",
                textColor = MaterialTheme.colorScheme.primary,
                buttonColor = MaterialTheme.colorScheme.surface
            )
        }
    }
}

@Composable
fun TimerSession(
    modifier: Modifier = Modifier,
    timer: String,
    incremento: () -> Unit = {},
    decremento: () -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BorderIcons(icon = R.drawable.ic_minus, onTap = decremento)
        }

        AutoResizedText(
            text = timer,
            modifier = Modifier
                .fillMaxWidth()
                .weight(8f)
                .align(Alignment.CenterVertically),
            textStyle = MaterialTheme.typography.displayLarge.copy(
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BorderIcons(icon = R.drawable.ic_plus, onTap = incremento)
        }
    }

}


@Composable
fun TimerTypeSession(
    modifier: Modifier = Modifier,
    onTap: () -> Unit = {}
) {
    val gridCount = 3
    val itemsSpacing = Arrangement.spacedBy(FocusTimerYTTheme.dimens.paddingNormal)
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxWidth()
            .height(FocusTimerYTTheme.dimens.spacerLarge),
        columns = GridCells.Fixed(gridCount),
        horizontalArrangement = itemsSpacing,
        verticalArrangement = itemsSpacing,
    ) {
        item(
            key = "1"
        ) {
            TimerTypeItem(
                text = "Focus Time",
                textColor = MaterialTheme.colorScheme.primary
            )
        }
        item(
            key = "2"
        ) {
            TimerTypeItem(
                text = "Short Time",
                textColor = MaterialTheme.colorScheme.secondary
            )
        }
        item(
            key = "3"
        ) {
            TimerTypeItem(
                text = "Long Time",
                textColor = MaterialTheme.colorScheme.secondary
            )
        }
    }
}


@Preview(
    name = "HomeScreen",
    showBackground = true
)
@Composable
fun HomeScreenPreview() {
    FocusTimerYTTheme {
        HomeScreen()
    }
}