package com.b1a9idps.clotheshouse.service

import com.b1a9idps.clotheshouse.service.dto.CategoryDto

interface CategoryService {
    fun list() : List<CategoryDto>
    fun get(id : Long) : CategoryDto
}
