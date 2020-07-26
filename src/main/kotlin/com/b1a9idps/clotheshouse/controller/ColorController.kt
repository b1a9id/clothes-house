package com.b1a9idps.clotheshouse.controller

import com.b1a9idps.clotheshouse.service.ColorService
import com.b1a9idps.clotheshouse.service.dto.ColorDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/colors")
class ColorController(val colorService: ColorService) {

    @GetMapping
    fun list() : List<ColorDto> {
        return colorService.list()
    }
}
