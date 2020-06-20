package com.b1a9idps.clotheshouse.service.dto

import com.b1a9idps.clotheshouse.entity.Item

data class ItemDto (
    val id: Long?,
    val imageUrl: String?,
    val brand: BrandDto?,
    val color: ColorDto?,
    val genre: GenreDto?) {
    companion object {
        fun newInstance(item : Item, brand : BrandDto, color : ColorDto, genre : GenreDto) : ItemDto {
            return ItemDto(item.id, item.imageUrl, brand, color, genre)
        }
    }
}
