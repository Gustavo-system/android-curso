package com.demos.inventario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.demos.inventario.core.navigation.NavigationHost
import com.demos.inventario.ui.theme.InventarioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InventarioTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationHost()
                }
            }
        }
    }
}
