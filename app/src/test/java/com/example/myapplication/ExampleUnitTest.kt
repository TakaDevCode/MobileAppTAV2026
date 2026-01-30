package com.example.myapplication

import android.app.Application
import com.example.myapplication.viewmodel.ApiViewModel
import com.example.myapplication.viewmodel.UsuarioViewModel
import io.kotest.core.spec.style.FunSpec
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldNotBeEmpty
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.mockk.mockk
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest : FunSpec(){
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

}
