package com.b1a9idps.clotheshouse.service.impl

import com.b1a9idps.clotheshouse.assert.BrandAssert
import com.b1a9idps.clotheshouse.assert.BrandDtoAssert
import com.b1a9idps.clotheshouse.entity.Brand
import com.b1a9idps.clotheshouse.exception.NotFoundException
import com.b1a9idps.clotheshouse.repository.BrandRepository
import com.b1a9idps.clotheshouse.service.dto.BrandCreateDto
import com.b1a9idps.clotheshouse.service.dto.BrandEditDto
import org.assertj.core.api.Assertions
import org.assertj.core.groups.Tuple
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mockito
import java.util.*

internal class BrandServiceImplTest {

    @Test
    fun list() {
        val stof = "stof"
        val bedsidedrama = "bedsidedrama"

        val brandRepository = Mockito.mock(BrandRepository::class.java)
        val brandService = BrandServiceImpl(brandRepository)

        val brands = listOf(Brand(stof, 1), Brand(bedsidedrama, 2))
        Mockito.`when`(brandRepository.findAll()).thenReturn(brands)

        Assertions.assertThat(brandService.list())
                .extracting("id", "name")
                .containsExactly(Tuple.tuple(1L, stof), Tuple.tuple(2L, bedsidedrama))
    }

    @Test
    fun get() {
        val brandRepository = Mockito.mock(BrandRepository::class.java)
        val brandService = BrandServiceImpl(brandRepository)

        val brand = Brand("stof", 1)
        Mockito.`when`(brandRepository.findById(eq(1L))).thenReturn(Optional.of(brand))

        BrandDtoAssert.assertThat(brandService.get(1))
                .hasId(1L)
                .hasName("stof")
    }

    @Test
    fun create() {
        val argumentCaptor = ArgumentCaptor.forClass(Brand::class.java)
        val brandRepository = Mockito.mock(BrandRepository::class.java)
        val brandService = BrandServiceImpl(brandRepository)

        val brandCreateDto = BrandCreateDto("stof")
        brandService.create(brandCreateDto)

        Mockito.verify(brandRepository).save(argumentCaptor.capture())
        BrandAssert.assertThat(argumentCaptor.value).hasName("stof")
    }

    @Nested
    inner class EditTest {
        @Test
        fun edit() {
            val argumentCaptor = ArgumentCaptor.forClass(Brand::class.java)
            val brandRepository = Mockito.mock(BrandRepository::class.java)
            val brandService = BrandServiceImpl(brandRepository)

            val brand = Brand( "stof", 1)
            Mockito.`when`(brandRepository.findById(eq(1L)))
                    .thenReturn(Optional.of(brand))

            val brandEditDto = BrandEditDto("bedsidedrama")
            brandService.edit(1L, brandEditDto)

            Mockito.verify(brandRepository).save(argumentCaptor.capture())
            BrandAssert.assertThat(argumentCaptor.value)
                    .hasId(1L)
                    .hasName("bedsidedrama")
        }

        @Test
        fun notFound() {
            val brandRepository = Mockito.mock(BrandRepository::class.java)
            val brandService = BrandServiceImpl(brandRepository)

            val brandEditDto = BrandEditDto("bedsidedrama")
            Mockito.`when`(brandRepository.findById(eq(10L)))
                    .thenThrow(NotFoundException())

            Assertions.assertThatThrownBy { brandService.edit(10L, brandEditDto) }
                    .isInstanceOf(NotFoundException::class.java)
        }
    }

    @Test
    fun delete() {
        val brandRepository = Mockito.mock(BrandRepository::class.java)
        val brandService = BrandServiceImpl(brandRepository)

        Assertions.assertThatCode { brandService.delete(1L) }
                .doesNotThrowAnyException()
        Mockito.verify(brandRepository).deleteById(eq(1L))
    }
}
