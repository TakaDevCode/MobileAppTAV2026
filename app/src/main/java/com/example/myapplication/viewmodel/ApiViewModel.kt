package com.example.myapplication.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.Usuario
import com.example.myapplication.repository.APIUsuarios
import kotlinx.coroutines.launch
import kotlin.collections.emptyList

class ApiViewModel(   private val repo: APIUsuarios = APIUsuarios()) : ViewModel() {


    var usuarios = mutableStateListOf<Usuario>()
        private set
    fun obtenerUsuariosResponse() = viewModelScope.launch {
        try {
            val response = repo.obtenerUsuarios()
            if (response.isSuccessful) {
                val users = response.body() ?: emptyList()
                usuarios.clear()
                usuarios.addAll(users)
            } else {
                println("Error: ${response.code()} ${response.message()}")
            }
        } catch (e: Exception) {
            println("Excepción de red: ${e.message}")
        }
    }

    //Agregar
    fun agregarUsuarioResponse(usuario: Usuario) = viewModelScope.launch {
        val response = repo.agregarUsuario(usuario)
        if (response.isSuccessful) {
            println("Usuario agregado exitosamente")
        } else {
            println("Error: ${response.code()} ${response.message()}")
        }
    }
}


