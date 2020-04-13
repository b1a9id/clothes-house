package com.b1a9idps.clotheshouse.service.dto

import java.net.URI

data class ItemDto (
    val id: Int,
    val imageUrl: URI,
    val brand: BrandDto,
    val color: ColorDto,
    val genre: GenreDto
)
