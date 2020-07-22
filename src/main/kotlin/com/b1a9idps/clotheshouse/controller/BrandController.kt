package com.b1a9idps.clotheshouse.controller

import com.b1a9idps.clotheshouse.service.BrandService
import com.b1a9idps.clotheshouse.service.dto.BrandDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/brands")
class BrandController(val brandService: BrandService) {

    @GetMapping
    fun list() : List<BrandDto> {
        return brandService.list()
    }
}
