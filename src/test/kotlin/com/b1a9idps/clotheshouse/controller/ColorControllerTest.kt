package com.b1a9idps.clotheshouse.controller

import com.b1a9idps.clotheshouse.service.ColorService
import com.b1a9idps.clotheshouse.service.dto.ColorDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
internal class ColorControllerTest {
    @MockBean
    lateinit var colorService: ColorService
    @Autowired
    lateinit var mockMvc: MockMvc
    @Autowired
    lateinit var mapper: ObjectMapper

    @Test
    fun list() {
        val colors = listOf(
                ColorDto(1, "BLACK"),
                ColorDto(2, "BLUE"))

        Mockito.`when`(colorService.list()).thenReturn(colors)

        val result = mockMvc.perform(get("/colors"))
                .andExpect(status().isOk)
                .andReturn()
        Assertions.assertThat(result.response.contentAsString)
                .isEqualTo(mapper.writeValueAsString(colors))
    }
}
