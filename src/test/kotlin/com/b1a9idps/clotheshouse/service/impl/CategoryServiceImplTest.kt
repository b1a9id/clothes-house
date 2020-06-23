package com.b1a9idps.clotheshouse.service.impl

import com.b1a9idps.clotheshouse.entity.Category
import com.b1a9idps.clotheshouse.repository.CategoryRepository
import org.assertj.core.api.Assertions
import org.assertj.core.groups.Tuple
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.eq
import org.mockito.Mockito
import java.util.*

internal class CategoryServiceImplTest {

    @Test
    fun list() {
        val categoryRepository = Mockito.mock(CategoryRepository::class.java)
        val categoryService = CategoryServiceImpl(categoryRepository)

        val categories = listOf(Category(1, "TOPS"), Category(2, "OUTER"))
        Mockito.`when`(categoryRepository.findAll()).thenReturn(categories)

        Assertions.assertThat(categoryService.list())
                .extracting("id", "name")
                .containsExactly(Tuple.tuple(1L, "TOPS"), Tuple.tuple(2L, "OUTER"))
    }

    @Test
    fun get() {
        val categoryRepository = Mockito.mock(CategoryRepository::class.java)
        val categoryService = CategoryServiceImpl(categoryRepository)

        val category = Category(1, "TOPS")
        Mockito.`when`(categoryRepository.findById(eq(1L))).thenReturn(Optional.of(category))

        Assertions.assertThat(categoryService.get(1))
                .extracting("id", "name")
                .containsExactly(1L, "TOPS")
    }
}
