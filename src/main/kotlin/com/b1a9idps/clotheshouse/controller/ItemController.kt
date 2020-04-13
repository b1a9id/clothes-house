package com.b1a9idps.clotheshouse.controller

import com.b1a9idps.clotheshouse.service.ItemService
import com.b1a9idps.clotheshouse.service.dto.ItemDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/items")
class ItemController(
        private val itemService: ItemService) {

    @GetMapping
    fun list() : List<ItemDto> {
        return itemService.list()
    }
}
