package com.b1a9idps.clotheshouse.service.impl

import com.b1a9idps.clotheshouse.entity.Category
import com.b1a9idps.clotheshouse.repository.CategoryRepository
import com.b1a9idps.clotheshouse.service.CategoryService
import com.b1a9idps.clotheshouse.service.dto.CategoryDto
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(val categoryRepository: CategoryRepository) : CategoryService {

    private val categoryDtoTransformer : (Category) -> CategoryDto =
            { category -> CategoryDto.newInstance(category) }

    override fun list(): List<CategoryDto> {
        return categoryRepository.findAll()
                .map(categoryDtoTransformer)
    }

    override fun get(id: Long): CategoryDto {
        return categoryRepository.findById(id)
                .map(categoryDtoTransformer)
                .orElse(null)
    }
}
