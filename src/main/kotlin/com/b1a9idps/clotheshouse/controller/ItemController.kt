package com.b1a9idps.clotheshouse.controller

import com.b1a9idps.clotheshouse.controller.request.ItemCreateRequest
import com.b1a9idps.clotheshouse.service.ItemService
import com.b1a9idps.clotheshouse.service.dto.ItemCreateDto
import com.b1a9idps.clotheshouse.service.dto.ItemDto
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/items")
class ItemController(
        private val itemService: ItemService) {

    @GetMapping
    fun list() : List<ItemDto> {
        return itemService.list()
    }

    @GetMapping("{id}")
    fun get(@PathVariable id : Long) : ItemDto {
        return itemService.get(id)
    }

    @PostMapping
    fun create(@RequestBody @Validated request : ItemCreateRequest) {
        itemService.create(ItemCreateDto.newInstance(request))
    }
}
