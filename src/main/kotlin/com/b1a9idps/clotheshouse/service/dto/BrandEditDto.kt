package com.b1a9idps.clotheshouse.service.dto

import com.b1a9idps.clotheshouse.controller.request.BrandEditRequest

data class BrandEditDto(val name : String) {
    companion object {
        fun newInstance(request : BrandEditRequest) : BrandEditDto {
            return BrandEditDto(request.name)
        }
    }
}
