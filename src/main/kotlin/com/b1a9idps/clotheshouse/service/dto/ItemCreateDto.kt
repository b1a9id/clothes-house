package com.b1a9idps.clotheshouse.service.dto

import com.b1a9idps.clotheshouse.controller.request.ItemCreateRequest

data class ItemCreateDto(
        val imageUrl : String,
        val brandId : Long,
        val genreId : Long,
        val colorId: Long) {
    companion object {
        fun newInstance(request : ItemCreateRequest) : ItemCreateDto {
            return ItemCreateDto (
                    request.imageUrl,
                    request.brandId,
                    request.genreId,
                    request.colorId)
        }
    }
}
