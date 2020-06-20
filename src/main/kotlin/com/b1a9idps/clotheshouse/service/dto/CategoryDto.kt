package com.b1a9idps.clotheshouse.service.dto

import com.b1a9idps.clotheshouse.entity.Category

data class CategoryDto (
        val id: Long,
        val name: String) {
    companion object {
        fun newInstance(category: Category) : CategoryDto {
            return CategoryDto(category.id, category.name)
        }
    }
}
