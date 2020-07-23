package com.b1a9idps.clotheshouse.controller

import com.b1a9idps.clotheshouse.service.BrandService
import com.b1a9idps.clotheshouse.service.dto.BrandDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
internal class BrandControllerTest {
    @MockBean
    lateinit var brandService: BrandService
    @Autowired
    lateinit var mockMvc : MockMvc
    @Autowired
    lateinit var mapper : ObjectMapper

    @Test
    fun list() {
        val brands = listOf(
                BrandDto(1, "stof"),
                BrandDto(2, "bedsidedrama"))

        Mockito.`when`(brandService.list()).thenReturn(brands)

        val result = mockMvc.perform(MockMvcRequestBuilders.get("/brands"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andReturn()
        Assertions.assertThat(result.response.contentAsString)
                .isEqualTo(mapper.writeValueAsString(brands))
    }
}
