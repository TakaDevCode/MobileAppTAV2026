package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.Usuario
import com.example.myapplication.repository.AppDatabase
import kotlinx.coroutines.launch

class UsuarioViewModel(app: Application) : AndroidViewModel(app) {
    private val usuarioDAO = AppDatabase.getDatabase(app).usuarioDao()
    val usuarios = usuarioDAO.obtenerUsuarios()

    fun insertarUsuario(username:String,correo:String,password:String) = viewModelScope.launch {
        val user = Usuario(username,correo,password)
        usuarioDAO.insert(user)
    }
    fun login (username:String, password:String) = viewModelScope.launch {
        usuarioDAO.login(username, password)
    }
    fun deleteUser(username:String) = viewModelScope.launch {
        usuarioDAO.deleteUser(username)
    }
    fun updateUsuario(username:String, correo:String, password:String) = viewModelScope.launch {
        usuarioDAO.updateUsuario(username, correo, password)
    }
}


