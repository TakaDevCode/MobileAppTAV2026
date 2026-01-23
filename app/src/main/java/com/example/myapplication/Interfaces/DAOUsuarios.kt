package com.example.myapplication.Interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.model.Usuario
import kotlinx.coroutines.flow.Flow

@Dao
interface DAOUsuarios {

    @Insert
    suspend fun insert(usuario: Usuario)


    @Query("SELECT * FROM Usuarios WHERE username = :username and password = :password")
    suspend fun login(username: String, password: String): Usuario

    @Query("delete from Usuarios where username = :username")
    suspend fun deleteUser(username:String)

    @Query("select * from Usuarios")
    fun obtenerUsuarios(): Flow<List<Usuario>>

    @Query("update Usuarios set correo = :correo, password = :password where username = :username")
    suspend fun updateUsuario(username:String, correo:String, password:String)


}