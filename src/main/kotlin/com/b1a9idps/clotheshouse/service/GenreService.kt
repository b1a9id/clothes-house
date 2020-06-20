package com.b1a9idps.clotheshouse.service

import com.b1a9idps.clotheshouse.service.dto.GenreDto

interface GenreService {
    fun list() : List<GenreDto>
    fun get(id : Long) : GenreDto
}
