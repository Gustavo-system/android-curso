package com.demos.geoauto.presentation.componets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demos.geoauto.presentation.screens.LocationScreen
import kotlinx.coroutines.launch

@Composable
fun MenuLateral() {
    val drawableState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawableState,
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            modifier = Modifier.padding(18.dp),
                            fontSize = 28.sp,
                            text = "GeoAuto"
                        )

                        Icon(
                            modifier = Modifier.size(40.dp).clickable {
                                scope.launch {
                                    drawableState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }
                            },
                            imageVector = Icons.Default.Close,
                            contentDescription = "close menu"
                        )
                    }

                    HorizontalDivider()

                    DrawerContent()
                }
            }
        },
        gesturesEnabled = false
    ) {
        Scaffold(
            topBar = {
                TopBarScreen(onOpenDrawer = {
                    scope.launch {
                        drawableState.apply {
                            if (isClosed) open() else close()
                        }
                    }
                })
            }
        ) { padding ->
            LocationScreen(modifier = Modifier.padding(padding))
        }
    }
}

@Composable
fun DrawerContent() {
    NavigationDrawerItem(
        modifier = Modifier,
        icon = {
            Icon(
                modifier = Modifier,
                imageVector = Icons.Default.Favorite,
                contentDescription = "Menu"
            )
        },
        label = {
            Text(
                modifier = Modifier.padding(18.dp),
                fontSize = 20.sp,
                text = "Mis autos"
            )
        },
        selected = false,
        onClick = {}
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarScreen(
    onOpenDrawer: () -> Unit
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(0.6f)
        ),
        navigationIcon = {
            Icon(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(40.dp)
                    .clickable {
                        onOpenDrawer()
                    },
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu"
            )
        },
        title = {}
    )
}