package com.example.wagwanworld  // ← your package name

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wagwanworld.ui.theme.WagwanWorldTheme  // ← keep your theme import

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WagwanWorldTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HelloScreen()
                }
            }
        }
    }
}

@Composable
fun HelloScreen() {
    // This is "remember" + "mutableStateOf" → state that survives recompositions
    var message by remember { mutableStateOf("Hello from Kampala!") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = message,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            message = if (message == "Hello from Kampala!") {
                "Kotlin + Compose is awesome! 🚀"
            } else {
                "Hello from Kampala!"
            }
        }) {
            Text("Change Message")
        }
    }
}

