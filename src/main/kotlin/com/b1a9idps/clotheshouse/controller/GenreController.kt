package com.b1a9idps.clotheshouse.controller

import com.b1a9idps.clotheshouse.service.GenreService
import com.b1a9idps.clotheshouse.service.dto.GenreDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/genres")
class GenreController(val genreService: GenreService) {

    @GetMapping
    fun list() : List<GenreDto> {
        return genreService.list()
    }
}
