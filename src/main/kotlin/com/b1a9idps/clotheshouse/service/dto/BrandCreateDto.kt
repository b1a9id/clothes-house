package com.b1a9idps.clotheshouse.service.dto

import com.b1a9idps.clotheshouse.controller.request.BrandCreateRequest

data class BrandCreateDto (val name: String)  {
    companion object {
        fun newInstance(request : BrandCreateRequest) : BrandCreateDto {
            return BrandCreateDto(request.name)
        }
    }
}
