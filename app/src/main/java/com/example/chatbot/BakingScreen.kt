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
    var response by remember { mutableStateOf("") } // Declare response state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "COPBOT",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 50.dp, bottom = 30.dp)
        )

        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            placeholder = { Text(text = "Enter Your Query here..") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )

        Button(
            onClick = {
                response = getResponse(query) // Update response state
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(text = "Send", color = Color.White)
        }

        if (response.isNotEmpty()) {
            Text(
                text = response,
                fontSize = 18.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(top = 20.dp)
            )
        }
    }
}

fun getResponse(query: String): String {
    return when {
        query.contains("hello", ignoreCase = true) -> "Hello! I'm CopBot How can I assist you?"
        query.contains("how are you", ignoreCase = true) -> "I'm just a bot, but I'm here to help!"
        query.contains("bye", ignoreCase = true) -> "Goodbye! Have a great day!"
        else -> "I'm not sure, but I'll try to improve!"
    }
}

@Preview(showSystemUi = true)
@Composable
fun CopBotScreenPreview() {
    CopBotScreen()
}
