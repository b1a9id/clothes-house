package com.b1a9idps.clotheshouse.service.dto

import com.b1a9idps.clotheshouse.entity.Brand

data class BrandDto (
        val id: Long,
        val name: String) {
    companion object {
        fun newInstance(brand : Brand) : BrandDto{
            return BrandDto(brand.id, brand.name)
        }
    }
}
