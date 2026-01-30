package com.example.myapplication

import com.example.myapplication.model.Usuario
import com.example.myapplication.repository.APIUsuarios
import com.example.myapplication.viewmodel.ApiViewModel
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class PruebasUnitarias : FunSpec({
    val testDispatcher = StandardTestDispatcher()

    beforeTest {
        Dispatchers.setMain(testDispatcher)
    }

    afterTest {
        Dispatchers.resetMain()
    }

    test("obtenerUsuariosResponse debe cargar usuarios exitosamente") {
        runTest(testDispatcher) {
            // Given
            val mockRepo = mockk<APIUsuarios>()
            val usuariosEsperados = listOf(
                Usuario("Jose", "jose@correo.cl", "1234"),
                Usuario("Sasha", "sasha@correo.cl", "1234"),
                Usuario("Juan", "juan@correo.cl", "1234"),
                Usuario("Maria", "maria@correo.cl", "1234")

            )

            coEvery { mockRepo.obtenerUsuarios() } returns Response.success(usuariosEsperados)

            // Pasar el mock al ViewModel
            val viewModel = ApiViewModel(repo = mockRepo)

            // When
            viewModel.obtenerUsuariosResponse()
            testDispatcher.scheduler.advanceUntilIdle()

            // Then
            viewModel.usuarios shouldHaveSize 4
        }
    }
})
