package com.b1a9idps.clotheshouse.service.impl

import com.b1a9idps.clotheshouse.assert.BrandAssert
import com.b1a9idps.clotheshouse.entity.Brand
import com.b1a9idps.clotheshouse.repository.BrandRepository
import org.assertj.core.api.Assertions
import org.assertj.core.groups.Tuple
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mockito
import java.util.*

internal class BrandServiceImplTest {

    @Test
    fun list() {
        val brandRepository = Mockito.mock(BrandRepository::class.java)
        val brandService = BrandServiceImpl(brandRepository)

        val brands = listOf(Brand("stof", 1), Brand("bedsidedrama", 2))
        Mockito.`when`(brandRepository.findAll()).thenReturn(brands)

        Assertions.assertThat(brandService.list())
                .extracting("id", "name")
                .containsExactly(Tuple.tuple(1L, "stof"), Tuple.tuple(2L, "bedsidedrama"))
    }

    @Test
    fun get() {
        val brandRepository = Mockito.mock(BrandRepository::class.java)
        val brandService = BrandServiceImpl(brandRepository)

        val brand = Brand("stof", 1)
        Mockito.`when`(brandRepository.findById(eq(1L))).thenReturn(Optional.of(brand))

        BrandAssert.assertThat(brandService.get(1))
                .hasId(1L)
                .hasName("stof")
    }
}
