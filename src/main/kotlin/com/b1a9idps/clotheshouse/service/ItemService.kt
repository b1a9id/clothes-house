package com.b1a9idps.clotheshouse.service

import com.b1a9idps.clotheshouse.service.dto.ItemCreateDto
import com.b1a9idps.clotheshouse.service.dto.ItemDto

interface ItemService {
    fun list() : List<ItemDto>
    fun get(id : Long) : ItemDto
    fun create(request : ItemCreateDto)
}
