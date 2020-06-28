package com.b1a9idps.clotheshouse.service

import com.b1a9idps.clotheshouse.service.dto.BrandCreateDto
import com.b1a9idps.clotheshouse.service.dto.BrandDto
import com.b1a9idps.clotheshouse.service.dto.BrandEditDto

interface BrandService {
    fun list() : List<BrandDto>
    fun get(id: Long) : BrandDto
    fun create(brandCreateDto : BrandCreateDto)
    fun edit(id : Long, brandEditDto: BrandEditDto)
    fun delete(id : Long)
}
