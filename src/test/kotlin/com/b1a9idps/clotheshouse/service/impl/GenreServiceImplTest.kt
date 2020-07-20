package com.b1a9idps.clotheshouse.service.impl

import com.b1a9idps.clotheshouse.entity.Genre
import com.b1a9idps.clotheshouse.repository.GenreRepository
import com.b1a9idps.clotheshouse.service.CategoryService
import com.b1a9idps.clotheshouse.service.dto.CategoryDto
import org.assertj.core.api.Assertions
import org.assertj.core.groups.Tuple
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mockito
import java.util.*

internal class GenreServiceImplTest {

    @Test
    fun list() {
        val shirtsName = "Shirts"
        val coatName = "Coat"
        val topsName = "TOPS"
        val outerName = "OUTER"

        val genreRepository = Mockito.mock(GenreRepository::class.java)
        val categoryService = Mockito.mock(CategoryService::class.java)
        val genreService = GenreServiceImpl(genreRepository, categoryService)

        val genres = listOf(Genre(shirtsName, 1, 1), Genre(coatName, 2, 2))
        Mockito.`when`(genreRepository.findAll()).thenReturn(genres)

        Mockito.`when`(categoryService.get(eq(1L))).thenReturn(CategoryDto(1, topsName))
        Mockito.`when`(categoryService.get(eq(2L))).thenReturn(CategoryDto(2, outerName))

        Assertions.assertThat(genreService.list())
                .extracting("id", "name", "categoryName")
                .containsExactly(Tuple.tuple(1L, shirtsName, topsName), Tuple.tuple(2L, coatName, outerName))
    }

    @Test
    fun get() {
        val genreRepository = Mockito.mock(GenreRepository::class.java)
        val categoryService = Mockito.mock(CategoryService::class.java)
        val genreService = GenreServiceImpl(genreRepository, categoryService)

        Mockito.`when`(genreRepository.findById(eq(1L))).thenReturn(Optional.of(Genre("Shirts", 1, 1)))
        Mockito.`when`(categoryService.get(eq(1L))).thenReturn(CategoryDto(1, "TOPS"))

        Assertions.assertThat(genreService.get(1L))
                .extracting("id", "name", "categoryName")
                .containsExactly(1L, "Shirts", "TOPS")
    }
}
