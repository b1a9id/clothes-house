package com.b1a9idps.clotheshouse.controller

import com.b1a9idps.clotheshouse.service.GenreService
import com.b1a9idps.clotheshouse.service.dto.GenreDto
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
internal class GenreControllerTest {
    @MockBean
    lateinit var genreService: GenreService
    @Autowired
    lateinit var mockMvc: MockMvc
    @Autowired
    lateinit var mapper: ObjectMapper

    @Test
    fun list() {
        val genres = listOf(
                GenreDto(1, "PANTS", "PANTS"),
                GenreDto(2, "KNIT", "TOPS"))

        Mockito.`when`(genreService.list()).thenReturn(genres)

        val result = mockMvc.perform(get("/genres"))
                .andExpect(status().isOk)
                .andReturn()
        Assertions.assertThat(result.response.contentAsString)
                .isEqualTo(mapper.writeValueAsString(genres))
    }
}
