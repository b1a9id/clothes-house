package com.b1a9idps.clotheshouse.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
internal class SinglePageControllerTest {
    @Autowired
    lateinit var mockMvc : MockMvc
    @Autowired
    lateinit var mapper : ObjectMapper

    @Test
    fun index() {
        mockMvc.perform(get("/anything"))
                .andExpect(status().isOk)
                .andExpect(forwardedUrl("/index.html"))
    }
}
