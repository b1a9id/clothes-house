package com.b1a9idps.clotheshouse.service.impl

import com.b1a9idps.clotheshouse.entity.Color
import com.b1a9idps.clotheshouse.repository.ColorRepository
import org.assertj.core.api.Assertions
import org.assertj.core.groups.Tuple
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mockito
import java.util.*

internal class ColorServiceImplTest {

    @Test
    fun list() {
        val blackName = "BLACK"
        val whiteName = "WHITE"

        val colorRepository = Mockito.mock(ColorRepository::class.java)
        val colorService = ColorServiceImpl(colorRepository)

        val colors = listOf(Color(blackName, 1), Color(whiteName, 2))
        Mockito.`when`(colorRepository.findAll()).thenReturn(colors)

        Assertions.assertThat(colorService.list())
                .extracting("id", "name")
                .containsExactly(Tuple.tuple(1L, blackName), Tuple.tuple(2L, whiteName))
    }

    @Test
    fun get() {
        val colorRepository = Mockito.mock(ColorRepository::class.java)
        val colorService = ColorServiceImpl(colorRepository)

        val color = Color("BLACK", 1)
        Mockito.`when`(colorRepository.findById(eq(1L))).thenReturn(Optional.of(color))

        Assertions.assertThat(colorService.get(1))
                .extracting("id", "name")
                .containsExactly(1L, "BLACK")
    }
}
