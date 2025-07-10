package com.example.focustimeryt.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.focustimeryt.R
import com.example.focustimeryt.presentation.theme.FocusTimerYTTheme

@Composable
fun BorderIcons(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    onTap: () -> Unit = {}
){
    Icon(
        modifier = modifier
            .size(FocusTimerYTTheme.dimens.iconSizeNormal)
            .border(
                width = FocusTimerYTTheme.dimens.borderNormal,
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            )
            .padding(FocusTimerYTTheme.dimens.paddingSmall)
            .clickable { onTap() },
        imageVector = ImageVector.vectorResource(id = icon),
        contentDescription = null,
        tint = MaterialTheme.colorScheme.primary
    )
}

@Preview(name = "BorderIconsPreview", showBackground = true)
@Composable
fun BorderIconsPreview() {
    BorderIcons(icon = R.drawable.ic_launcher_foreground)
}