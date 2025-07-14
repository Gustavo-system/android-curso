package com.demos.rickandmorty.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.demos.rickandmorty.models.Results
import com.demos.rickandmorty.presentation.viewmodels.PersonajesViewModel

@Composable
fun PersonajesScreen(
    viewModel: PersonajesViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Log.d("Cantidad items", "${state.size}")

    LazyColumn(modifier = Modifier.padding(top = 24.dp).fillMaxWidth()) {
        items(state) { personaje ->
            PersonajeCard(personaje = personaje)
        }
    }
}


@Composable
fun PersonajeCard(
    modifier: Modifier = Modifier,
    personaje: Results
) {

    var expanded by remember { mutableStateOf(false) }

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
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
                )
                {
                    AsyncImage(
                        model = personaje.image,
                        contentDescription = personaje.name,
                        contentScale = ContentScale.FillBounds
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterVertically)
                        .weight(1f)
                )
                {
                    Text(
                        text = personaje.name,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        val color = when(personaje.status) {
                            "Alive" -> Color.Green
                            "Dead" -> Color.Red
                            else -> Color.Gray
                        }

                        Box(
                            modifier = Modifier.padding(2.dp)
                                .clip(CircleShape)
                                .background(color)
                                .size(12.dp)
                        )

                        Text(
                            text = "${personaje.status} - ${personaje.species}",
                            style = MaterialTheme.typography.titleSmall
                        )
                    }

                }

                IconButton(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    onClick = {
                        expanded = !expanded
                    }
                )
                {
                    Icon(
                        imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = "More Information"
                    )
                }

            }

            if(expanded) {
                Row(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Column {
                        Text(
                            text = "Last episode",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = personaje.location.name,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}