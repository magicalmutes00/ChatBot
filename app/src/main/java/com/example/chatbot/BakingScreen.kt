package com.example.chatbot

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CopBotScreen() {
    var query by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // App Title
        Text(
            text = "COPBOT",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 50.dp, bottom = 30.dp)
        )

        // Input Field
        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            placeholder = { Text(text = "Enter Your Query here..") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )

        // Send Button
        Button(
            onClick = { /* TODO: Handle query submission */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier
                .padding(top = 10.dp)
        ) {
            Text(text = "Send", color = Color.White)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CopBotScreenPreview() {
    CopBotScreen()
}
