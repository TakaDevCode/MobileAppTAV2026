@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay
import android.R.drawable.ic_secure as loginImageVector


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Inicial(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inicial(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    Scaffold(
        modifier = Modifier.fillMaxSize()

    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Row() {
                Column() {
                    //Centered content
                    Text(
                        "Hola",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(16.dp)
                    )
                    Button(onClick = {
                        context.startActivity(Intent(context, SegundaVentana::class.java))
                    }) {
                        Text("Click")
                    }
                }
            }
        }
    }
}

@Composable
fun formulario(modifier: Modifier = Modifier) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var pass2 by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(false) }

    var context = LocalContext.current
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = loginImageVector),
            contentDescription = "Logo",
            //Rounded corner modifier
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )
        Text(
            "Username",
            modifier = modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        OutlinedTextField(value = username, onValueChange = { username = it })
        Text(
            "Password",
            modifier = modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            //Type password
            visualTransformation = PasswordVisualTransformation(),
        )
        Text(
            "Confirme contraseña",
            modifier = modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        OutlinedTextField(
            value = pass2,
            onValueChange = { pass2 = it },
            //Type password
            visualTransformation = PasswordVisualTransformation(),
        )
        OutlinedButton(
            onClick = { isLoading = true },
            enabled = !isLoading,
            modifier = Modifier.padding(16.dp)
        ) {
            if (username.isNotEmpty() && password.isNotEmpty()) {
                CircularProgressIndicator(modifier = Modifier.size(20.dp))
                Spacer(Modifier.width(8.dp))
                isLoading = false
            }
            Text(if (isLoading) "Cargando..." else "Enviar")
        }


    }


}


suspend fun espera() {
    delay(1000L)
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        formulario()
    }
}