package com.b1a9idps.clotheshouse.service

import com.b1a9idps.clotheshouse.service.dto.BrandDto

interface BrandService {
    fun list() : List<BrandDto>
    fun get(id: Long) : BrandDto
}
