package com.demos.rickandmorty.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.demos.rickandmorty.models.Results
import com.demos.rickandmorty.presentation.viewmodels.PersonajesViewModel

@Composable
fun PersonajesScreen(
    modifier: Modifier,
    viewModel: PersonajesViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Log.d("Cantidad items", "${state.size}")

    LazyColumn {
        items(state) { personaje ->
            PersonajeCard(modifier = modifier, personaje = personaje)
        }
    }
}


@Composable
fun PersonajeCard(
    modifier: Modifier = Modifier,
    personaje: Results
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Column {
            Row {
                Surface(
                    modifier = Modifier.size(120.dp),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
                ) {
                    AsyncImage(
                        model = personaje.image,
                        contentDescription = personaje.name,
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
        }
    }
}