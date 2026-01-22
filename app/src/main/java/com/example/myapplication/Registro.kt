package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

@OptIn(ExperimentalMaterial3Api::class)
class Registro : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text("Ventana 3") },

                            )
                    }
                ) { innerPadding ->

                    RegisterScreen(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
    var correo by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var password2 by remember { mutableStateOf("") }

    val context = LocalContext.current
    //add topappbar
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Ventana de Registro", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.padding(vertical = 16.dp))
        Text("Username", style = MaterialTheme.typography.headlineSmall)
        OutlinedTextField(value = username, onValueChange = { username = it })
        Text("Correo", style = MaterialTheme.typography.headlineSmall)
        OutlinedTextField(value = correo, onValueChange = { correo = it })
        Text("Contraseña", style = MaterialTheme.typography.headlineSmall)
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation(),
        )
        Text("Confirme contraseña", style = MaterialTheme.typography.headlineSmall)
        OutlinedTextField(value = password2, onValueChange = { password2 = it })
        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        //Rectangle shape button with rounded corner
        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.padding(16.dp)


        ) {
            Text("Registrar")


        }


    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    MyApplicationTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = { Text("Ventana 3") },
                    navigationIcon = {
                        IconButton(onClick = { /*Volver*/ }) {
                            Icon(Icons.Filled.ArrowBack, null)

                        }
                    },
                    actions={
                        IconButton(onClick = { /* acción */ }) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    }
                    )
            }
        ) { innerPadding ->

            RegisterScreen(modifier = Modifier.fillMaxSize().padding(innerPadding))

        }
    }
}