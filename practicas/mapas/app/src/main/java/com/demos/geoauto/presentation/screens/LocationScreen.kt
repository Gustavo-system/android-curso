package com.demos.geoauto.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.demos.geoauto.presentation.viewmodels.LocationViewModel
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.android.gms.maps.model.CameraPosition

@Composable
fun LocationScreen(modifier: Modifier) {
    Box(modifier.fillMaxSize()) {
        MapsLocation(modifier = Modifier.align(Alignment.Center), viewModel = LocationViewModel())
    }
}

@Composable
fun MapsLocation(modifier: Modifier, viewModel: LocationViewModel) {

    val location: LatLng by viewModel.ubicacionActual.observeAsState(initial = LatLng(19.4326, -99.1332))

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(location, 18f)
    }

    Column(modifier = modifier) {
        GoogleMap(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            cameraPositionState = cameraPositionState
        ) {
            Marker(
                state = MarkerState(position = location),
                title = "Mi carro",
                snippet = "Última posición"
            )
        }
    }
}