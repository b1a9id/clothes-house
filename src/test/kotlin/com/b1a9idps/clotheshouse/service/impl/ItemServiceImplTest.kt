package com.b1a9idps.clotheshouse.service.impl

import com.b1a9idps.clotheshouse.entity.Item
import com.b1a9idps.clotheshouse.repository.ItemRepository
import com.b1a9idps.clotheshouse.service.BrandService
import com.b1a9idps.clotheshouse.service.ColorService
import com.b1a9idps.clotheshouse.service.GenreService
import com.b1a9idps.clotheshouse.service.dto.BrandDto
import com.b1a9idps.clotheshouse.service.dto.ColorDto
import com.b1a9idps.clotheshouse.service.dto.GenreDto
import org.assertj.core.api.Assertions
import org.assertj.core.groups.Tuple
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mockito
import java.util.*

internal class ItemServiceImplTest {

    @Test
    fun list() {
        val itemRepository = Mockito.mock(ItemRepository::class.java)
        val brandService = Mockito.mock(BrandService::class.java)
        val colorService = Mockito.mock(ColorService::class.java)
        val genreService = Mockito.mock(GenreService::class.java)
        val itemService = ItemServiceImpl(itemRepository, brandService, colorService, genreService)

        val items = listOf(
                Item(1, 1, 1, "https://b1a9idps.com", 1),
                Item(2, 2, 2, "https://b1a9idps.com", 2))

        Mockito.`when`(itemRepository.findAll()).thenReturn(items)
        Mockito.`when`(brandService.get(eq(1L))).thenReturn(BrandDto(1, "stof"))
        Mockito.`when`(colorService.get(eq(1L))).thenReturn(ColorDto(1, "BLACK"))
        Mockito.`when`(genreService.get(eq(1L))).thenReturn(GenreDto(1, "Shirts", "TOPS"))
        Mockito.`when`(brandService.get(eq(2L))).thenReturn(BrandDto(2, "bedsidedrama"))
        Mockito.`when`(colorService.get(eq(2L))).thenReturn(ColorDto(2, "WHITE"))
        Mockito.`when`(genreService.get(eq(2L))).thenReturn(GenreDto(2, "Coat", "OUTER"))

        Assertions.assertThat(itemService.list())
                .extracting(
                        "id",
                        "imageUrl",
                        "brand.id",
                        "brand.name",
                        "color.id",
                        "color.name",
                        "genre.id",
                        "genre.name",
                        "genre.categoryName")
                .containsExactly(
                        Tuple.tuple(1L, "https://b1a9idps.com", 1L, "stof", 1L, "BLACK", 1L, "Shirts", "TOPS"),
                        Tuple.tuple(2L, "https://b1a9idps.com", 2L, "bedsidedrama", 2L, "WHITE", 2L, "Coat", "OUTER"))
    }

    @Test
    fun get() {
        val itemRepository = Mockito.mock(ItemRepository::class.java)
        val brandService = Mockito.mock(BrandService::class.java)
        val colorService = Mockito.mock(ColorService::class.java)
        val genreService = Mockito.mock(GenreService::class.java)
        val itemService = ItemServiceImpl(itemRepository, brandService, colorService, genreService)

        val item = Item(1, 1, 1,"https://b1a9idps.com", 1)
        Mockito.`when`(itemRepository.findById(eq(1L))).thenReturn(Optional.of(item))
        Mockito.`when`(brandService.get(eq(1L))).thenReturn(BrandDto(1, "stof"))
        Mockito.`when`(colorService.get(eq(1L))).thenReturn(ColorDto(1, "BLACK"))
        Mockito.`when`(genreService.get(eq(1L))).thenReturn(GenreDto(1, "Shirts", "TOPS"))

        Assertions.assertThat(itemService.get(1L))
                .extracting(
                        "id",
                        "imageUrl",
                        "brand.id",
                        "brand.name",
                        "color.id",
                        "color.name",
                        "genre.id",
                        "genre.name",
                        "genre.categoryName")
                .containsExactly(1L, "https://b1a9idps.com", 1L, "stof", 1L, "BLACK", 1L, "Shirts", "TOPS")
    }
    
}
