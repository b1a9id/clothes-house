package com.b1a9idps.clotheshouse.controller

import com.b1a9idps.clotheshouse.TestUtils.Companion.any
import com.b1a9idps.clotheshouse.controller.request.ItemCreateRequest
import com.b1a9idps.clotheshouse.service.ItemService
import com.b1a9idps.clotheshouse.service.dto.*
import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
internal class ItemControllerTest {
    @MockBean
    lateinit var itemService : ItemService
    @Autowired
    lateinit var mockMvc : MockMvc
    @Autowired
    lateinit var mapper : ObjectMapper

    @Test
    fun list() {
        val item = ItemDto(
                1,
                "https://b1a9idps.com",
                BrandDto(1, "ETHOSENS"),
                ColorDto(1, "BLUE"),
                GenreDto(1, "Shirt", "TOPS"))
        val items = listOf(item)
        Mockito.`when`(itemService.list()).thenReturn(items)

        val result = mockMvc.perform(get("/items"))
                .andExpect(status().isOk)
                .andReturn()
        Assertions.assertThat(result.response.contentAsString)
                .isEqualTo(mapper.writeValueAsString(items))
    }

    @Test
    fun get() {
        val item = ItemDto(
                1,
                "https://b1a9idps.com",
                BrandDto(1, "ETHOSENS"),
                ColorDto(1, "BLUE"),
                GenreDto(1, "Shirt", "TOPS"))
        Mockito.`when`(itemService.get(eq(1L))).thenReturn(item)

        val result = mockMvc.perform(get("/items/{id}", 1))
                .andExpect(status().isOk)
                .andReturn()
        Assertions.assertThat(result.response.contentAsString)
                .isEqualTo(mapper.writeValueAsString(item))
    }

    @Test
    fun create() {
        Mockito.doNothing().`when`(itemService).create(any(ItemCreateDto::class.java))
        val request = ItemCreateRequest("https://b1a9idps.com", 1, 1, 1)

        mockMvc.perform(post("/items")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(request)))
                .andExpect(status().isOk)
        Mockito.verify(itemService).create(any(ItemCreateDto::class.java))
    }
}
